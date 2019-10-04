
/**
 * This class cotrolls the experiment.
 * calling simulation with different kinds of data that are gathered in csv files.
 *
 * @Lekso Borashvili
 * test cases:
 * 4,2,3
 * 4,2,5
 * 4,2,7
 * 6,2,3
 * 6,2,5
 * 6,2,7
 * 4,4,3
 * 4,4,5
 * 4,4,7
 * 6,4,5
 * 6,4,5
 * 6,4,7
 * 
 * 
 */
import java.io.FileWriter;
import java.time.*;
/**
 * Runs simulation for each case 10 times and prints data in output files.
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

        Result res = new Result();
        for(int i=0;i<10;i++)
        {
        Result result = new Result();
        result = run.Runner(10,3,2,OrderType.HOAGIE,"output2.csv");
        res.setAverageWaitTime(res.getAverageWaitTime()+result.getAverageWaitTime());
        res.setTotalRevenue(res.getTotalRevenue()+result.getTotalRevenue());
        res.setAverageNumberofIdleCashiers(res.getAverageNumberofIdleCashiers()+result.getAverageNumberofIdleCashiers());
        res.setAverageNumberofIdleCooks(res.getAverageNumberofIdleCooks()+result.getAverageNumberofIdleCooks());
        }
        
        LocalDateTime rightNow = LocalDateTime.now(); 
        fw.write(rightNow + " - FirstRun - Average Wait Time = " + res.getAverageWaitTime()/10 + "; ");
        fw.write("Total Revenue = " + res.getTotalRevenue()/10 + " ");
        fw.write("Average Number of Idle Cashiers = " + res.getAverageNumberofIdleCashiers()/10 + " ");
        fw.write("Average NUmber of Idle Cooks = " + res.getAverageNumberofIdleCooks()/10);
        fw.write('\n');
        
        fw.close();
        
    }
}
