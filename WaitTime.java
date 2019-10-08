
/**
 * Write a description of class satisfaction here.
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class WaitTime
{
    private ArrayList<Integer> wt = new ArrayList<Integer>();
    
    public void addtoWaitTime(int a)
    {
        wt.add(a);
    }
    
    public int getfromWaitTime(int i)
    {
        return wt.get(i);
    }
    
    public int WaitTimeSize()
    {
        return wt.size();
    }
    
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
