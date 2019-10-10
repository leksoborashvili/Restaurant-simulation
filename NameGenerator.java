
/**
 * Generates names of the output files
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
public class NameGenerator
{
    public static String generateCSV(int k,OrderType orderType)
    {
        String ans = "output";
        ans=ans+Integer.toString(k)+orderType+".csv";
        return ans;
    }
}
