
/**
 * Write a description of class Cooks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cooks
{
    private int ID;
    private int numberofCooks;
    private int timetoFinishOrder;
    private Order order;
    
    
    
    public void setNumberofCooks(int a)
    {
        numberofCooks=a;
    }
    public int getNumberofCooks()
    {
        return numberofCooks;
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
