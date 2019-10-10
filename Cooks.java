
/**
 * Contains Information about each cook
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
public class Cooks extends Staff
{
    private int ID;
    private int number;
    private double sallary;
    
    private int timetoFinishOrder;
    private Order order;
    
    /**
     * sets sallary of the cooks
     * @param x amount of sallary
     */
    public void setSallary(double x)
    {
        sallary=x;
    }
    /**
     * returns sallary
     * @return get sallary
     */
    public double getSallary()
    {
        return sallary;
    }
    /**
     * sets number of cooks
     * @param a number of cooks
     */
    public void setNumberofCooks(int a)
    {
        number=a;
    }
    /**
     * returns number of cooks
     * @return number
     */
    public int getNumberofCooks()
    {
        return number;
    }
    /**
     * sets ID for a cook
     * @param a ID of a cook
     */
    public void setID(int a)
    {
        ID=a;
    }
    /**
     * return ID of a cook
     * @return ID of a cook
     */
    public int getID()
    {
        return ID;
    }
    /**
     * sets the time cook needs to finish the order in minutes
     * @param a time necessary to finish the order
     */
    public void setTimetoFinishOrder(int a)
    {   
        timetoFinishOrder=a;
    }
    /**
     * returns time necessary to finish the order
     * @return time necessary to finish the order
     */
    public int getTimetoFinishOrder()
    {
        return timetoFinishOrder;
    }
    /**
     * sets the order cook is working on
     * @param o the order object
     */
    public void setOrder(Order o)
    {
        order=o;
    }
    /**
     * return order the cook is working on
     * @return Order object
     */
    public Order getOrder()
    {
        return order;
    }
}
