
/**
 * This class cotrolls the experiment.
 * calling simulation with different kinds of data that are gathered in csv files.
 *
 * @Lekso Borashvili
 * 
 * 
 * 
 */
import java.io.FileWriter;
import java.time.*;
/**
 * Contains Main method that can run different cases of simulation
 * 
 */
public class ExperimentController
{
    /**
     * Controls experiment gathers data and saves it in data files
     */
    public static void main(String[] args) throws Exception
    {
        Run run = new Run();
        FileWriter fw = new FileWriter("logger.txt");
        
        
        int[] cases ={20,2,5,
                      18,2,5,
                      16,2,5,
                      14,2,5,
                      12,2,5,
                      10,2,5,
                      15,2,5,
                      13,2,5,
                      };
        
        
        
        for(int j =0;j<24;j=j+3)
        {
            int numberofCooks = cases[j];
            int numberofCashiers = cases[j+1];
            int numberofMaxCustomers = cases[j+2];
            OrderType orderType = null;
            for(int k=0;k<3;k++)
            {
                //creating the output file using case number and restaurant type
                String output = "output" + Integer.toString(j/3);
                if(k==0) {output = output + "HOAGIE"; orderType = OrderType.HOAGIE;}
                if(k==1) {output = output + "PIZZA"; orderType = OrderType.PIZZA;}
                if(k==2) {output = output + "BAGEL"; orderType = OrderType.BAGEL;}
                output+=".csv";
                //result is collected in this object
                Result res = new Result();
                res.setAverageWaitTime(0);
                res.setTotalRevenue(0);
                res.setAverageNumberofIdleCashiers(0);
                res.setAverageNumberofIdleCooks(0);
                //Each case is run 10 times and answer is average of all 10 cases
                for(int i=0;i<10;i++)
                {
                    Result result = new Result();
                    result = run.Runner(numberofCooks,numberofCashiers,numberofMaxCustomers,orderType,output);
                    res.setAverageWaitTime(res.getAverageWaitTime()+result.getAverageWaitTime());
                    res.setTotalRevenue(res.getTotalRevenue()+result.getTotalRevenue());
                    res.setAverageNumberofIdleCashiers(res.getAverageNumberofIdleCashiers()+result.getAverageNumberofIdleCashiers());   
                    res.setAverageNumberofIdleCooks(res.getAverageNumberofIdleCooks()+result.getAverageNumberofIdleCooks());
                    res.setOrderVolume(res.getOrderVolume()+result.getOrderVolume());
                }
            
                //this logs the average data of every scenario
                LocalDateTime rightNow = LocalDateTime.now(); 
                fw.write( "Cooks = " +numberofCooks);
                fw.write(" Cashiers = " + numberofCashiers);
                fw.write(" MaxCustomers = " + numberofMaxCustomers);
                fw.write(" OrderType = " + orderType);
                fw.write("  averageWaitTime = " + res.getAverageWaitTime()/10 + "; ");
                fw.write("TotRev = " + res.getTotalRevenue()/10 + "; ");
                fw.write("Order Volume = " + res.getOrderVolume()/10 + "; ");
                fw.write("AvNumofIdleCashiers = " + res.getAverageNumberofIdleCashiers()/10 + "; ");
                fw.write("AvNumofIdleCooks = " + res.getAverageNumberofIdleCooks()/10);
                
                fw.write('\n');
            }    
        }
    
        fw.close();
        
    }
}
