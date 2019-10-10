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
     * 
     * this method runs the main simulation and returns result for the given case.
     * @param numberofCooks Number of cooks
     * @param numberofCashiers Number of cashiers
     * @param maxCustomers The max number of customers that can enter the retaurant per minute
     * @param ordertype Type of the order
     * @param output Name of the file output should be printed
     * @param log object that prints in logger file 
     * @return returns Result class object containing average wait time, Revenue, Number of Idle cooks and cashiers.
     */
    public Result Runner(int numberofCooks,int numberofCashiers, int maxCustomers,OrderType ordertype,String output,FileWriter log) throws Exception
    {
        //t is how we keep track of the time 
        int t=0;
        
        //logger
        log.write(output + " is created");
        log.write('\n');
        //this creates output file where we print the data
        FileWriter fw = new FileWriter(output);
        fw.write("number of cooks =" + numberofCooks + ",");
        fw.write("number of max customers per minute = " + maxCustomers + ",");
        fw.write("number of Cashiers = " + numberofCashiers + ",");
        fw.write('\n');
        
        //logger
        log.write("Customer and cashier objects are created sallary is set");
        log.write('\n');
        //objects of customer and cashier class that will be used during the simulation
        Customer customer = new Customer();
        Cashier cashier = new Cashier();
        cashier.setSallary(7.25);
        
        //logger
        log.write("Variables for average data are generated");
        log.write('\n');
        //we keep track of data using these variables that will be returned as a result
        int idleCashiers = 0;
        int idleCooks = 0;
        int totalRevenue = 0;
        int orderVolume = 0;
        WaitTime wt = new WaitTime();
        
        //logger
        log.write("Array of cooks is generated");
        log.write('\n');
        //we have cooks arraylist to keep track of all the cooks
        ArrayList<Cooks> cooksArray = new ArrayList<Cooks>();
        
        //adding all the cooks to the arraylist 
        //all cooks have 7.25 sallary state of pennsylvania minimum wage
        for(int i=0;i<numberofCooks;i++)
        {
            Cooks cook = new Cooks();
            cook.setID(i);
            //if timetofinishorder is 0 then that cook is free
            cook.setTimetoFinishOrder(0);
            cook.setSallary(7.25);
            cooksArray.add(cook);
        }
        
        //logger
        log.write("Queue for the orders is generated");
        log.write('\n');
        //this is queue for the orders 
        Queue <Order> orderQ = new ArrayDeque<Order>();
        
        //Order counter needs to be static which causes it to increase for every run
        //So we need to nullify it before every simulation
        Order ordercounternullifier = new Order();
        ordercounternullifier.nullifyOrderCounter();
        
        //the order 
        fw.write("Order Number,Time Taken,Number of Ordered Things,Excess Wait Time ");
        fw.write('\n');
        
        //this bool will be used so that restaurant runs until every order is finished
        
        //but restaurant will not take orders after 12 hours
        boolean bool = true;
        //the restaurant will work until every order is satisfied but wont take any customers after its usual working time.
        //the code runs 720 minutes simulation
        
        //logger
        log.write("The simulation starts");
        log.write('\n');
        while(t<720 || orderQ.size()>0 || bool)
        {
            //logger
            log.write("t = " + t);
            log.write('\n');
            //we control how many cashiers work at a time
            cashier.setNumberofCashiers(numberofCashiers);
            
            //in the start of every minute customers will be added in the line of cashiers.
            if((t<720) && (t%2==0))
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
            
            //logger
            log.write("Number of customers ordered = " + numberofCustomersOrdered);
            log.write('\n');
            //we need to add numberOfCustomersOrdered orders in the queue that will be then used by the cooks
            for(int i=0;i<numberofCustomersOrdered;i++)
            {
                orderVolume++;
                Order order = new Order(t);
                order.setType(ordertype);
                order.setNumberofOrderedItems();
                order.setTimetoFinishOrder();
                orderQ.add(order);
                //logger
                log.write("Order #" + order.getID() + " is generated");
                log.write('\n');
            }
            
            //here cooks take orders and those who are busy decrease the time of timetofinish order by 1
            for(int i=0;i<numberofCooks;i++)
            {
                int timetoFinishOrder = cooksArray.get(i).getTimetoFinishOrder();
                
                //here nothing happens except time to finish order is reduced by 1
                if(timetoFinishOrder > 1) 
                {
                    //logger
                    log.write("Cook #" + cooksArray.get(i).getID() + " is cooking");
                    log.write('\n');
                    
                    cooksArray.get(i).setTimetoFinishOrder(timetoFinishOrder-1); 
                    continue;
                }
                
                
                //this is the case when the cook finishes the order so we need to gather data
                if(timetoFinishOrder == 1)
                {
                    //here will be data how long the order took to finish
                   
                    //this portion of code writes the data in CSV file
                    fw.write(cooksArray.get(i).getOrder().getID()+",");
                    int timeTaken = t - cooksArray.get(i).getOrder().getOrderTime();
                    fw.write(timeTaken + ",");
                    fw.write(cooksArray.get(i).getOrder().getNumberofOrderedItems() + ",");
                    fw.write(timeTaken - cooksArray.get(i).getOrder().getTimetoFinishOrder() + ",");
                    fw.write('\n');
                    
                    //we have separate class to calculate average excess wait time of each customer
                    wt.addtoWaitTime(timeTaken - cooksArray.get(i).getOrder().getTimetoFinishOrder());
                    //here we calculate the total revenue
                    totalRevenue+=cooksArray.get(i).getOrder().getPrice();
                    
                    //sets the cook that finished the order free
                    cooksArray.get(i).setTimetoFinishOrder(0);
                    
                    //logger
                    log.write("Cook #" + cooksArray.get(i).getID() + "finished cooking order #" +
                    cooksArray.get(i).getOrder().getID());
                    log.write('\n');
                } 
                
                //if cook is free he gets a new order if there are any available
                if(timetoFinishOrder == 0)
                {
                    if(orderQ.size() > 0)
                    {
                        Order order = orderQ.remove();
                        cooksArray.get(i).setOrder(order);
                        cooksArray.get(i).setTimetoFinishOrder(order.getTimetoFinishOrder());
                        
                        //logger
                        log.write("Cook #" + cooksArray.get(i).getID() + " starts cooking order #" + 
                        cooksArray.get(i).getOrder().getID());
                        log.write('\n');
                        continue;
                    }
                }
            }
            //every minute we check how many cooks are idle
            for(int i=0;i<numberofCooks;i++)
            {
                if(cooksArray.get(i).getTimetoFinishOrder()==0) {idleCooks++;}
            }
            
            //this will keep while loop running if there are cooks still cooking
            if(t>=720) bool=false;
            for(int i=0;i<numberofCooks;i++)
            {
                if(cooksArray.get(i).getTimetoFinishOrder()>0) bool=true;
            }
            
            t++;
           
        }
        
        
        //deducting the Cashier and Cook Sallaries.
        totalRevenue = totalRevenue - (int)(numberofCashiers*12*cashier.getSallary());
        totalRevenue = totalRevenue - (int)(numberofCooks*(t/60)*cooksArray.get(0).getSallary());
        
        
        Result result = new Result();
        result.setOrderVolume(orderVolume);
        result.setAverageWaitTime(wt.avgWaitTime());
        result.setAverageNumberofIdleCooks(idleCooks/t);
        result.setAverageNumberofIdleCashiers(idleCashiers/720);
        result.setTotalRevenue(totalRevenue);
        
        fw.close();
        
        return result;
    }
}