/**
 * To run the code you should run the main method of Run class and provide numberofcooks numberofCashiers and maxCustomers
 * "10","3","20"
 * @Lekso Borashvili (your name)
 * @1.0.0 (a version number or a date)
 */
import java.util.*;
import java.io.FileWriter;
public class Run
{
    /**
     * this method runs the main simulation.
     * we have to give it number of cooks, cashiers and max customers that enter the store randomly
     * type of the restaurant we are simulating
     * the name of the file we want to print the data
     * also the file name that we want to print the data in
     */
    public Result Runner(int numberofCooks,int numberofCashiers, int maxCustomers,OrderType ordertype,String output ) throws Exception
    {
        int t=0;
        
        //this creates output file where we print the data
        FileWriter fw = new FileWriter(output);
        
        fw.write("number of cooks =" + numberofCooks + ",");
        fw.write("number of max customers per minute = " + maxCustomers + ",");
        fw.write("number of Cashiers = " + numberofCashiers + ",");
        fw.write('\n');
        
        Customer customer = new Customer();
        Cashier cashier = new Cashier();
        int idleCashiers = 0;
        int idleCooks = 0;
        int totalRevenue = 0;
        
        ArrayList<Cooks> cooksArray = new ArrayList<Cooks>();
        //adding all the cooks to the arraylist if timetofinishorder is 0 then that cook is free
        for(int i=0;i<numberofCooks;i++)
        {
            Cooks cook = new Cooks();
            cook.setID(i);
            cook.setTimetoFinishOrder(0);
            cooksArray.add(cook);
        }
        
        
        Queue <Order> orderQ = new ArrayDeque<Order>();
        WaitTime wt = new WaitTime();
        //this bool will be used so that restaurant runs until every order is finished
        //but restaurant will not take orders after 12 hours of interval
        
        //the code runs 720 minutes simulation
        fw.write("Order Number,Time Taken,Number of Ordered Things,Excess Wait Time ");
        fw.write('\n');
        
        boolean bool = true;
        //the restaurant will work until 120 so every order is satisfied but wont take any customers after its usual time.
        
        while(t<720 || orderQ.size()>0 || bool)
        {
            
            //we control how many cashiers work at a time
            cashier.setNumberofCashiers(numberofCashiers);
            
            //in the start of every minute customers will be added in the line of cashiers.
            if((t<720) && (t % 3 == 0))
            {
                customer.increaseNumberofCustomersOrdering(customer.getNextCustomerWave(maxCustomers));
                
            }
            
            //every minute cashier will serve one customer getting his order.
            //we need to check if the number of free cashiers is enough for the number of customers in a line
            //we will need to keep track of number of custoemrs ordering every minute. we will use it later
            int numberofCustomersOrdered = 0;
            if(customer.getNumberofCustomersOrdering() > cashier.getNumberofCashiers())
                {
                    customer.setNumberofCustomersOrdering(customer.getNumberofCustomersOrdering()-cashier.getNumberofCashiers());
                    numberofCustomersOrdered = cashier.getNumberofCashiers();
            }else {
                numberofCustomersOrdered = customer.getNumberofCustomersOrdering();
                customer.setNumberofCustomersOrdering(0);
            }
            if(t>720) numberofCustomersOrdered=0;
            
            //here is idle cashiers counted
            if(t<720)idleCashiers=idleCashiers+cashier.getNumberofCashiers()-numberofCustomersOrdered;
            
            //we need to add numberOfCustomersOrdered orders in the queue that will be then used by the cooks
            for(int i=0;i<numberofCustomersOrdered;i++)
            {
                Order order = new Order(t);
                order.setType(ordertype);
                order.setNumberofOrderedItems();
                order.setTimetoFinishOrder();
                orderQ.add(order);
                
            }
            
            //here cooks take orders and those who are busy decrease the time of timetofinish order by 1
            for(int i=0;i<numberofCooks;i++)
            {
                int timetoFinishOrder = cooksArray.get(i).getTimetoFinishOrder();
                if(timetoFinishOrder > 1) {cooksArray.get(i).setTimetoFinishOrder(timetoFinishOrder-1); continue;}
                
                
                
                if(timetoFinishOrder == 1)
                {
                    //here will be data how long the order took to finish
                   
                    fw.write(cooksArray.get(i).getOrder().getID()+",");
                    int timeTaken = t - cooksArray.get(i).getOrder().getOrderTime();
                    fw.write(timeTaken + ",");
                    fw.write(cooksArray.get(i).getOrder().getNumberofOrderedItems() + ",");
                    fw.write(timeTaken - cooksArray.get(i).getOrder().getTimetoFinishOrder() + ",");
                    fw.write('\n');
                    wt.addtoWaitTime(timeTaken - cooksArray.get(i).getOrder().getTimetoFinishOrder());
                    totalRevenue+=cooksArray.get(i).getOrder().getPrice();
                    cooksArray.get(i).setTimetoFinishOrder(0);
                
                } 
            
                if(timetoFinishOrder == 0)
                {
                    if(orderQ.size() > 0)
                    {
                        Order order = orderQ.remove();
                        cooksArray.get(i).setOrder(order);
                        cooksArray.get(i).setTimetoFinishOrder(order.getTimetoFinishOrder());
                        continue;
                    }
                }
            }
            for(int i=0;i<numberofCooks;i++)
            {
                if(cooksArray.get(i).getTimetoFinishOrder()==0) {idleCooks++;}
            }
            
            if(t>720) bool=false;
            
            for(int i=0;i<numberofCooks;i++)
            {
                if(cooksArray.get(i).getTimetoFinishOrder()>0) bool=true;
            }
            
            t++;
           
        }
        
        Result result = new Result();
        result.setAverageWaitTime(wt.avgWaitTime());
        result.setAverageNumberofIdleCooks(idleCooks/t);
        result.setAverageNumberofIdleCashiers(idleCashiers/720);
        result.setTotalRevenue(totalRevenue);
        
        fw.close();
        
        return result;
    }
}