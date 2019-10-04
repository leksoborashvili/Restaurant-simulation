 
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
    
    private OrderType type;
    
    private int price;
    
    private int numberofOrderedItems;
    
    private int timetoFinishOrder;
    
    
    
    /**
     * Constructor that sets order time as well
     */
    public Order(int ot)
    {
        orderTime = ot;
        orderCounter++;
        ID=orderCounter;
    }
    /**
     * Returns price of the order
     */
    public int getPrice()
    {
        return price;
    }
    /**
     *  setting order time
     */
    public void setOrderTime(int ot)
    {
        orderTime = ot;
    }
    /**
     * returns order time
     */
    public int getOrderTime()
    {
        return orderTime;
    }
    /**
     * sets the type of order(pizza,hoagie,bagel)
     */
    public void setType(OrderType s)
    {
        type=s;
    }
    /**
     * returns enum of the order type
     */
    public OrderType getType()
    {
         return type;
    }
    /**
     * setting number of ordered items
     */
    public void setNumberofOrderedItems()
    {
        Random random = new Random();
        if(OrderType.PIZZA.equals(type)) numberofOrderedItems = random.nextInt(3)+1;
        if(OrderType.BAGEL.equals(type)) numberofOrderedItems = random.nextInt(6)+1; 
        if(OrderType.HOAGIE.equals(type)) numberofOrderedItems = random.nextInt(4)+1;
    }
    /**
     * returns the number of items the customer ordered
     */
    public int getNumberofOrderedItems()
    {
        return numberofOrderedItems;
    }
    /**
     * sets time to finish order
     */
    public void setTimetoFinishOrder()
    {
      if(OrderType.PIZZA.equals(type)) {timetoFinishOrder =  15 * numberofOrderedItems; price = 16 * numberofOrderedItems;}
      
      if(OrderType.BAGEL.equals(type)) {timetoFinishOrder =   5 * numberofOrderedItems; price = 2 * numberofOrderedItems;}
      
      if(OrderType.HOAGIE.equals(type)) {timetoFinishOrder = 7 * numberofOrderedItems; price = 6 * numberofOrderedItems;}
    }
    /**
     * decreases time to finish order by 1
     */
    public void decreaseTimetoFinishOrder()
    {
        timetoFinishOrder--;
    }
    /**
     * returns time to finish order
     */
    public int getTimetoFinishOrder()
    {
        return timetoFinishOrder;
    }
    /**
     * returns ID
     */
    public int getID()
    {
        return ID;
    }
}
