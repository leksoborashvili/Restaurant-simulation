
/**
 * Write a description of class Cooks here.
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
    
    
    public void setSallary(double x)
    {
        sallary=x;
    }
    public double getSallary()
    {
        return sallary;
    }
    
    public void setNumberofCooks(int a)
    {
        number=a;
    }
    public int getNumberofCooks()
    {
        return number;
    }
    public void setID(int a)
    {
        ID=a;
    }
    public int getID()
    {
        return ID;
    }
    public void setTimetoFinishOrder(int a)
    {   
        timetoFinishOrder=a;
    }
    public int getTimetoFinishOrder()
    {
        return timetoFinishOrder;
    }
    public void setOrder(Order o)
    {
        order=o;
    }
    public Order getOrder()
    {
        return order;
    }
}
