
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class Customer
{
    public Customer()
    {
        numberofCustomersOrdering = 0;
    }
   
    //this is the number of customers in a line to order;\
    private int numberofCustomersOrdering;
    
    
    //returns random value of customers that visit the restaurant
    //max number of customers will be 10 at given time
    public static int getNextCustomerWave(int a)
    {
        Random random = new Random();
        return random.nextInt(a);
    }
    //we need this when more customers come to order
    public void increaseNumberofCustomersOrdering(int a)
    {
        numberofCustomersOrdering+=a;
    }
    //we use this to decrease the number of customers in line when cashiers are available
    public void setNumberofCustomersOrdering(int a)
    {
        numberofCustomersOrdering-=a;
    }
    //just to access the number of customers
    public int getNumberofCustomersOrdering()
    {
        return numberofCustomersOrdering;
    }
}
