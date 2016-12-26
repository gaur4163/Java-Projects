/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Gaurav
 */
public class Age {
 
   private int days;
   private int months;
   private int years;
 
   private Age()
   {
      //Prevent default constructor
   }
 
   public Age(int days, int months, int years)
   {
      this.days = days;
      this.months = months;
      this.years = years;
   }
 
   public int getDays()
   {
      return this.days;
   }
 
   public int getMonths()
   {
      return this.months;
   }
 
   public int getYears()
   {
      return this.years;
   }
 
   
} 

