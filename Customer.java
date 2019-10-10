
/**
 * Contains the information about how many customers are in the line to order
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
import java.util.Random;
public class Customer
{
    /**
     * sets the number of customers ordering to 0
     */
    public Customer()
    {
        numberofCustomersOrdering = 0;
    }
   
    //this is the number of customers in a line to order;\
    private int numberofCustomersOrdering;
    
    
    //returns random value of customers that visit the restaurant
    //max number of customers will be 10 at given time
    /**
     * returns random value of customers coming to the restaurant
     * @param a max number that random can reach
     * @return the random value of customers
     */
    public static int getNextCustomerWave(int a)
    {
        Random random = new Random();
        return random.nextInt(a);
    }
    //we need this when more customers come to order
    /**
     * increases number of customers in the line by number provided
     * @param a number of customers 
     */
    public void increaseNumberofCustomersOrdering(int a)
    {
        numberofCustomersOrdering+=a;
    }
    //we use this to decrease the number of customers in line when cashiers are available
    /**
     * sets the number of customers ordering 
     * @param a number of customers 
     */
    public void setNumberofCustomersOrdering(int a)
    {
        numberofCustomersOrdering=a;
    }
    //just to access the number of customers
    /**
     * returns number of customers in ordering line
     * @return number of customers in line
     */
    public int getNumberofCustomersOrdering()
    {
        return numberofCustomersOrdering;
    }
}
