 
/**
 * Keeps track of information about order
 * ID, order time, type(OrderType), price, number of ordered items, time to finish order
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
import java.util.Random;
public class Order
{
    private int ID;
    private static int orderCounter=0;
    
    //when the order is taken
    private int orderTime;
    
    
    
    private OrderType type;
    
    private int price;
    
    private int numberofOrderedItems;
    
    private int timetoFinishOrder;
    
    /**
     * Nullifies the number of items ordered before
     */
    public void nullifyOrderCounter()
    {
        orderCounter=0;
    }
    /**
     * constructor for order class
     */
    public Order()
    {}
    /**
     * creates new order with new ID 
     * @param ot The time item was ordered
     */
    public Order(int ot)
    {
        orderTime = ot;
        orderCounter++;
        ID=orderCounter;
    }
    /**
     * returns the price paid for the order
     * @return Returns price of the order
     */
    public int getPrice()
    {
        return price;
    }
    /**
     * sets the time the item was ordered
     *  @param ot time item was ordered
     */
    public void setOrderTime(int ot)
    {
        orderTime = ot;
    }
    /**
     * Return the time items was ordered
     * @return returns time the items was ordered
     */
    public int getOrderTime()
    {
        return orderTime;
    }
    /**
     * sets type of the order
     * @param s type of order(pizza,hoagie,bagel)
     */
    public void setType(OrderType s)
    {
        type=s;
    }
    /**
     * Return the type of order
     * @return returns enum type of the order
     */
    public OrderType getType()
    {
         return type;
    }
    /**
     * Randomly sets the number of ordered items 
     */
    public void setNumberofOrderedItems()
    {
        Random random = new Random();
        if(OrderType.PIZZA.equals(type)) numberofOrderedItems = random.nextInt(3)+1;
        if(OrderType.BAGEL.equals(type)) numberofOrderedItems = random.nextInt(6)+1; 
        if(OrderType.HOAGIE.equals(type)) numberofOrderedItems = random.nextInt(4)+1;
    }
    /**
     * return the number of items ordered
     * @return returns the number of items the customer ordered
     */
    public int getNumberofOrderedItems()
    {
        return numberofOrderedItems;
    }
    /**
     * calculates and sets time order takes to finish
     */
    public void setTimetoFinishOrder()
    {
      if(OrderType.PIZZA.equals(type)) {timetoFinishOrder =  10 * numberofOrderedItems; price = 17 * numberofOrderedItems;}
      
      if(OrderType.BAGEL.equals(type)) {timetoFinishOrder =   3 * numberofOrderedItems; price = 2 * numberofOrderedItems;}
      
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
     * returns necessary time to finish order
     * @return returns time to finish order
     */
    public int getTimetoFinishOrder()
    {
        return timetoFinishOrder;
    }
    /**
     * returns ID 
     * @return returns order ID
     */
    public int getID()
    {
        return ID;
    }
}
