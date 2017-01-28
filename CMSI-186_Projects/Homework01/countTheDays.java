/*
 *  File name     :  CountTheDays.java
 *  Purpose       :  Creating countTheDays.java program
 *  Author        :  Kevin Patterson
 *  Date          :  1/26/17
 *  Description   :  Creation of the countTheDays class. Calls upon methods in the CalendarStuff
 *                   class to run.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:     Reason for change/modification
 *           -----  ----------  ------------     -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  Kevin Patterson  Initial writing
 */

public class countTheDays{
  public static void main (String [] args){
    long m1 = Long.parseLong(args[0]);
    long d1 = Long.parseLong(args[1]);
    long y1 = Long.parseLong(args[2]);
    long m2 = Long.parseLong(args[3]);
    long d2 = Long.parseLong(args[4]);
    long y2 = Long.parseLong(args[5]);
    if(CalendarStuff.isValidDate(m1, d1, y1) == true && CalendarStuff.isValidDate(m2, d2, y2) == true){
        System.out.println("Between " + m1 " - " + d1 + " - " + y1 + " and " + m2 " - " + d2 + " - " + y2 + "There are :: "  + CalendarStuff.daysBetween(m1, d1, y1, m2, d2, y2) + "days");
      }
    else{
      System.out.println("Not valid. Please enter two valid dates.");
    }
    }
  }
}
