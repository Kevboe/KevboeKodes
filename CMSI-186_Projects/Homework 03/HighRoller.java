/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Create a dice game using DiceSet.java
 *  Author        :  Kevin Patterson
 *  Date          :  2017-02-23
 *  Description   :  Call on DiceSet.java to create a working highRoll game
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-23  K. Patterson  Creating Highroller and all of its methods.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 import java.util.Scanner;

 public class HighRoller {

   private DiceSet hr = null;

   public static void main( String[] args ) {
     int highScore = 0;
     String ans = "";
     int reroll = 0;
     Scanner k = new Scanner(System.in);
     DiceSet hr = new DiceSet( 6, 20);
     System.out.println("Welcome to HighRoll, The Game (tm)! \n Would you Like to play? y/n");
     ans = k.next();
     if( ans.equals( "y" ) ){
       while ( !ans.equals("q")) {
         System.out.println("YOU HAVE 6 20 SIDED DIE, GET THE HIGHEST SCORE POSSIBLE!");
         System.out.println( "Your currently have rolled :: " + hr.toString() );
         System.out.println( "What will you do?" );
         System.out.println( "(1) Reroll all the dice" );
         System.out.println( "(2) Roll a single die" );
         System.out.println( "(3) Calculate the total" );
         System.out.println( "(4) Save this score as the high score" );
         System.out.println( "(5) Display the current high score" );
         System.out.println("Enter the number of the option you'd like." );
         System.out.println( " --To quit enter 'q'-- " );
         ans = k.next();
         if( ans.equals("1")){
           hr.roll();
         }
         if( ans.equals("2")){
           System.out.println( "Which die would you like to reroll?" );
           reroll = k.nextInt();
           hr.rollIndividual( reroll );
         }
         if( ans.equals("3")){
           System.out.println("");
           System.out.println( "Your current total is :: " + hr.sum() );
         }
         if( ans.equals("4")){
           highScore = hr.sum();
           System.out.println("");
           System.out.println( "Your new high score of :: " + highScore + " was recorded and saved.");
         }
         if( ans.equals("5")){
           System.out.println("");
           System.out.println( "The current high score is :: " + highScore );
         }
         System.out.println("");
         System.out.println("");
       }
     }
   System.out.println( "Thanks! Come Again! ^_^" );
   }
 }
