
/**
 * Write a description of class Cashier here.
 *
 * @Lekso Borashvili
 * @version (a version number or a date)
 */
public class Cashier extends Staff
{
   private int number;
   private double sallary;
   
   public void setSallary(double x)
   {
        sallary=x;
   }
   public double getSallary()
   {
        return sallary;
   }
   
   public void setNumberofCashiers(int a)
   {
       number=a;
   }
   public int getNumberofCashiers()
   {
       return number;
   }
}
