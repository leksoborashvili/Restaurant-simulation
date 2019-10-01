 
/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class Order
{
    private int ID;
    
    //when the order is taken
    private int orderTime;
    
    private static int orderCounter=0;
    
    private int numberofBagels;
    private int numberofPizza;
    private int numberofHoagies;
    
    private int timeToFinishOrder;
    
    public Order(int ot)
    {
        orderTime = ot;
        orderCounter++;
        ID=orderCounter;
    }
    
    public void setOrderTime(int ot)
    {
        orderTime = ot;
    }
    public int getOrderTime()
    {
        return orderTime;
    }
    
    public void setNumberofBagels(int a)
    {
        Random random = new Random();
        numberofBagels=random.nextInt(a)+1;
    }
    public void setNumberofPizza(int a)
    {
        Random random = new Random();
        numberofPizza = random.nextInt(a)+1;
    }
    public void setNumberofHoagies(int a)
    {
        Random random = new Random();
        numberofHoagies = random.nextInt(a)+1;
    }
    public int getNumberofBagels()
    {
        return numberofBagels;
    }
    public int getNumberofPizza()
    {
        return numberofPizza;
    }
    public int getNumberofHoagies()
    {
        return numberofHoagies;
    }
    public void setTimetoFinishOrder()
    {
        timeToFinishOrder = numberofPizza*15 + numberofHoagies*7 + numberofBagels*5;
    
    }
    public void decreaseTimetoFinishOrder()
    {
        timeToFinishOrder--;
    }
    public int getTimetoFinishOrder()
    {
        return timeToFinishOrder;
    }
    public int getID()
    {
        return ID;
    }
}
