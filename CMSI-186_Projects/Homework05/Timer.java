/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Timer class to create a tick based off of the time slice.
 *  @author       :  Kevin Patterson
 *  Date written  :  2017-03-30
 *  Description   :  This class provides a bunch of methods which may be useful for the soccerSim
                     for homework 05
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-30  K. Patterson  Initial writing
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Timer{

  private double[] returnValue;

//All this code from tick is stole from BJ's github, and then modified. Thanks for the help!

 public double[] tick( double seconds, double minutes, double hours, double totalSeconds ) {
    totalSeconds += 1;
    returnValue = new double[4];
    returnValue[0] = totalSeconds % 60;
    returnValue[1] = (int)(totalSeconds / 60) % 60;
    returnValue[2] = (int)totalSeconds / 3600;
    returnValue[3] = totalSeconds;
    return returnValue;
 }


public String toString() {
  return "   " + returnValue[2] + " hours, " + returnValue[1] + " minutes, " + returnValue[0] + " seconds"
         + "\nTotal Seconds :: " + returnValue[3] ;
}
public static void main( String args[] ){
  Timer clock = new Timer();
  System.out.println(clock.tick(1, 23, 40, 0));
}
}
