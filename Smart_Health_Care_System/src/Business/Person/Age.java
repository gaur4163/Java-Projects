/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Apoorva
 */
public class Age {
 
   private int days;
   private String months;
   private int years;
 
  
   public Age(int days, String months, int years)
   {
      this.days = days;
      this.months = months;
      this.years = years;
   }
 
   public int getDays()
   {
      return this.days;
   }
 
   public String getMonths()
   {
      return this.months;
   }
 
   public int getYears()
   {
      return this.years;
   }

    @Override
    public String toString() {
        return days + "-" + months + "-" + years;
    }
 
   
} 
