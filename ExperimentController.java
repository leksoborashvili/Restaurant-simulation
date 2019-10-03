
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
public class ExperimentController
{
    public static void main(String[] args) throws Exception
    {
        Run run = new Run();
        run.Runner(10,3,2,OrderType.PIZZA,"output1.csv");
        
    
    }
}
