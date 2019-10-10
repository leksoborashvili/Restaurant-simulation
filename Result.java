
/**
 * Keeps track of the result for different simulations
 * average wait time, total revenue, average number of Idle cooks, average number of Idle cashiers, Order volume
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
public class Result
{
    private int averageWaitTime;
    private int TotalRevenue;
    private int averageNumberofIdleCashiers;
    private int averageNumberofIdleCooks;
    private int orderVolume;
    
    /**
     * sets average wait time
     * @param a average wait time
     */
    public void setAverageWaitTime(int a)
    {
        averageWaitTime = a;
    }
    /**
     * returns average wait time
     * @return average wait time
     */
    public int getAverageWaitTime()
    {
        return averageWaitTime;
    }
    /**
     * sets total revenue
     * @param a total revenue
     */
    public void setTotalRevenue(int a)
    {
        TotalRevenue=a;
    }
    /**
     * returns total revenue
     * @return total revenue
     */
    public int getTotalRevenue()
    {
        return TotalRevenue;
    }
    /**
     * sets average number of Idle cashiers
     * @param a number of Idle cashiers
     */
    public void setAverageNumberofIdleCashiers(int a)
    {
        averageNumberofIdleCashiers=a;
    }
    /**
     * returns average number of Idle cashiers
     * @return average number of Idle cashiers
     */
    public int getAverageNumberofIdleCashiers()
    {
        return averageNumberofIdleCashiers;
    }
    /**
     * sets average number of Idle cooks
     * @param a number of Idle cooks
     */
    public void setAverageNumberofIdleCooks(int a)
    {
        averageNumberofIdleCooks=a;
    }
    /**
     * returns average number of Idle cooks
     * @return average number of Idle cooks
     */
    public int getAverageNumberofIdleCooks()
    {
        return averageNumberofIdleCooks;
    }
    /**
     * sets order volume
     * @param a order volume
     */
    public void setOrderVolume(int a)
    {
        orderVolume=a;
    }
    /**
     * retuns order volume
     * @return order volume
     */
    public int getOrderVolume()
    {
        return orderVolume;
    }
}
