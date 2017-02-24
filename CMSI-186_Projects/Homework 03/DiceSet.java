/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-23  K. Patterson  Added code for all methods and test cases
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.util.*;

public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private int total;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of sides on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int numDie, int faces ) {
      this.count = numDie;
      this.sides = faces;
      ds = new Die[ numDie ];
      if(count < 1 ){
        throw new IllegalArgumentException("Need atleast 1 die to roll!");
      }
      if( sides < 4){
        throw new IllegalArgumentException("A die needs atleast 4 sides!");
      }
      for(int x = 0; x < count; x++){
        ds[x] = new Die(faces);
      }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     total = 0;
      for(int x = 0; x < count; x++){
        total = total + ds[x].getValue();
      }
      return total;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for(int x = 0; x < count; x++){
       ds[x].roll();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if(dieIndex - 1 > sides){
       throw new IllegalArgumentException("This die does not exist in your set");
     }
      int rollI = 0;
      rollI = ds[dieIndex - 1].roll();
      return rollI;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      if(dieIndex - 1 > sides){
        throw new IllegalArgumentException("This die does not exist in your set");
      }
      return ds[dieIndex - 1].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String rtrn = "";
      for(int x = 0; x < count; x++){
        rtrn = rtrn + "[" + ds[x].toString() + "]";
      }
      return rtrn;
   }

   public String toNumOnly(){
     String rtrn = "";
     for(int x = 0; x < count; x++){
       rtrn = rtrn + ds[x].toString();
     }
     return rtrn;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

  /**
   * @return  true iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
   String set1 = this.toNumOnly();
   String set2 = ds.toNumOnly();

   boolean same = false;

   int[] setra1 = new int[set1.length()];
   int[] setra2 = new int[set2.length()];

   for(int x = 0; x < set1.length(); x++){
     setra1[x] = Character.getNumericValue( set1.charAt( x ) );
   }
   for(int y = 0; y < set2.length(); y++){
     setra2[y] = Character.getNumericValue( set2.charAt( y ) );
   }
   Arrays.sort( setra1 );
   Arrays.sort( setra2 );

   if( Arrays.equals( setra1, setra2 ) == true ){
     same = true;
   }

      return same;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      // You do this part!
      System.out.println("You are now about to enter, the Dielight zone...");
      DiceSet ds1 = new DiceSet( 5, 6);
      DiceSet ds2 = new DiceSet( 2, 4);
      DiceSet ds3 = new DiceSet( 4, 12);
      ds1.roll();
      ds2.roll();
      ds3.roll();
      System.out.println( "Checking toString method for accurately printing out the dice set :: " + ds1.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the dice set :: " + DiceSet.toString(ds1) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds1.sum() );
      System.out.println( "Checking getIndividual for the die value at pos. 2 :: " + ds1.getIndividual(2) );
      System.out.println( "Checking rollIndividual for the new die value at pos. 2 :: " + ds1.rollIndividual(2) );
      System.out.println( "Checking toString method for accurately printing out the updated dice set :: " + ds1.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the updated dice set :: " + DiceSet.toString(ds1) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds1.sum() );
      System.out.println( "Checking isIdentical with ds1 and ds1, expecting true. Actual output :: " + ds1.isIdentical(ds1) );
      System.out.println();
      System.out.println( "Checking toString method for accurately printing out the dice set :: " + ds2.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the dice set :: " + DiceSet.toString(ds2) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds2.sum() );
      System.out.println( "Checking getIndividual for the die value at pos. 1 :: " + ds2.getIndividual(1) );
      System.out.println( "Checking rollIndividual for the new die value at pos. 1 :: " + ds2.rollIndividual(1) );
      System.out.println( "Checking toString method for accurately printing out the updated dice set :: " + ds2.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the updated dice set :: " + DiceSet.toString(ds2) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds2.sum() );
      System.out.println( "Checking isIdentical with ds1 and ds2, expecting false. Actual output :: " + ds1.isIdentical(ds2) );
      System.out.println();
      System.out.println( "Checking toString method for accurately printing out the dice set :: " + ds3.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the dice set :: " + DiceSet.toString(ds3) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds3.sum() );
      System.out.println( "Checking getIndividual for the die value at pos. 4 :: " + ds3.getIndividual(4) );
      System.out.println( "Checking rollIndividual for the new die value at pos. 4 :: " + ds3.rollIndividual(4) );
      System.out.println( "Checking toString method for accurately printing out the updated dice set :: " + ds3.toString() );
      System.out.println( "Checking class-wide toString method for accurately printing out the updated dice set :: " + DiceSet.toString(ds3) );
      System.out.println( "Checking sum for the total value of the dice :: " + ds3.sum() );
      System.out.println( "Checking isIdentical with ds3 and ds3, expecting true. Actual output :: " + ds3.isIdentical(ds3) );
      System.out.println();
      System.out.println("I am checking getIndividual and rollIndividual for errors by calling for a die that doesn't exist.");
      try{
        ds1.rollIndividual(10);
      }
      catch( IllegalArgumentException IAE1){
        System.out.println("This die does not exist in your set.");
      }
      try{
        ds1.getIndividual(10);
      }
      catch( IllegalArgumentException IAE2){
        System.out.println("This die does not exist in your set.");
      }
      System.out.println();
      System.out.println("I am checking for the error of an invalid number of sides or die");
      try{
        DiceSet dsError = new DiceSet(0, 3);
      }
      catch( IllegalArgumentException IAE3){
        System.out.println("I need atleast 1 die with a minimum of 4 sides to roll.");
      }
   }

}
