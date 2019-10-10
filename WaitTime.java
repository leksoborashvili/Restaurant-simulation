
/**
 * Keeps track of all the customer wait time
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class WaitTime
{
    
    private ArrayList<Integer> wt = new ArrayList<Integer>();
    /**
     * adds wait time to the list
     * @param a wait time 
     */
    public void addtoWaitTime(int a)
    {
        wt.add(a);
    }
    /**
     * returns i-th element from the wait time array
     * @param i index in array
     * @return i-th element value
     */
    public int getfromWaitTime(int i)
    {
        return wt.get(i);
    }
    
    /**
     * returns the size of wait time array
     * @return wait time array size 
     */
    public int WaitTimeSize()
    {
        return wt.size();
    }
    /**
     * returns the average wait time of every customer
     * @return average wait time
     */
    public int avgWaitTime()
    {
        int ans = 0;
        
        for(int i=0;i<wt.size();i++)
        {
            ans+=wt.get(i);
        }
        
        if(wt.size()==0) return 0;
        
        return ans/wt.size();
    }
    
    
        
    
}
