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

      public static String countTheDays( m1, d1, y1, m2, d2, y2){
        if(isValidDate(m1, d1, y1) == true && isValidDate(m2, d2, y2) == true){
          System.out.println("Between " + m1 + " - " + d1 + " - " + y1 + " and " + m2 + " - " + d2 + " - " + y2 + "There are :: "  + daysBetween(m1, d1, y1, m2, d2, y2) + "days");
        }
      else{
        System.out.println("Not valid. Please enter two valid dates.");
      }
    }


    public static boolean isLeapYear( long year ) {
       if ((year%100 == 0 && year%400 == 0) || (year%4 == 0 && year%100 != 0)){
         return true;
       }
       return false;
    }

    public static long daysInMonth( long month, long year ) {
       if((month< 8 && month%2 == 1) || (month == 8) || (month > 8 && month%2 == 0)){
         return 31;
       }
       else if(isLeapYear(year) == true && month == 2){
         return 29;
       }
       else if(isLeapYear(year) == false && month == 2){
         return 28;
       }
       else{
         return 30;
       }
    }

    public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      if( y1 < y2 || (m1 < m2 && y1 == y2) || (m1 == m2 && d1 < d2 && y1 == y2)){return -1;}
      else if( y1 > y2 || (m1 > m2 && y1 == y2) || (m1 == m2 && d1 > d2 && y1 == y2)){return 1;}
      else {return 0;}
    }

    public static boolean isValidDate( long month, long day, long year ) {
      if( month == 2){
        if( ( isLeapYear(year) == true) && (day <= 29 && day >= 1) && year >= 0){
          return true;
        }
        if( ( isLeapYear(year) == false) && (day <= 28 && day >= 1) && year >= 0){
          return true;
        }
        return false;
      }
      else if(( (month <= 7  && month > 0) && month%2 == 1) || ((month >= 8 && month <= 12) && month%2 == 0) && (day <= 31 && day >= 1) && year >= 0){
        return true;
      }
      else if(( (month <= 7 && month > 0) && month%2 == 0) || ((month >= 8 && month <= 12) && month%2 == 1) && (day <= 30 && day >= 1) && year >= 0){
        return true;
      }
      return false;
    }

    public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      long dayCount = 0;
      long m1 = m1;
      long m2 = m2;
      long d1 = d1;
      long d2 = d2;
      long y1 = y1;
      long y2 = y2;
      if(compareDate(m1, d1, y1, m2, d2, y2) == 0){
        return dayCount;
      }

      while(compareDate(m1, d1, y1, m2, d2, y2) == -1){
        d1++;
        dayCount++;
        if(d1 > daysInMonth(m1, y1)){
          m1++;
          d1 = 1;
        }
        if(m1 > 12){
          y1++;
          m1 = 1;
        }
      }
      while(compareDate(m1, d1, y1, m2, d2, y2) == 1){
        d2++;
        dayCount++;
        if(d2 > daysInMonth(m2, y2)){
          m1++;
          d2 = 1;
        }
        if(m2 > 12){
          y2++;
          m2 = 1;
        }
      }
    return dayCount;
    }
  }
}
