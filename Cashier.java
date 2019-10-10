
/**
 * Cashier class containing number of cashiers and their sallary
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
public class Cashier extends Staff
{
   private int number;
   private double sallary;
   
   /**
    * sets the sallary of cashiers
    * @param x amount of sallary
    */
   public void setSallary(double x)
   {
        sallary=x;
   }
   /**
    * returns the amount of sallary
    * @return sallary amount of sallary
    */
   public double getSallary()
   {
        return sallary;
   }
   
   /**
    * sets the number of cashiers
    * @param a number of cashiers
    *
    */
   public void setNumberofCashiers(int a)
   {
       number=a;
   }
   /**
    * returns number of cashiers
    * @return number of cashiers
    */
   public int getNumberofCashiers()
   {
       return number;
   }
}
