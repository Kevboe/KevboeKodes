/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  Kevin Patterson
 *  Date          :  2017-01-31
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  none
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:     Reason for change/modification
 *           -----  ----------  ------------     -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson     Initial writing and release
 *  @version 1.2.0  2017-01-31  Kevin Patterson  Adding in tester methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // fill in how many tests
      test_isPalindrome();       // fill in how many tests
      test_evensOnly();          // fill in how many tests
      test_oddsOnly();           // fill in how many tests
      test_evensOnlyNoDupes();   // fill in how many tests
      test_oddsOnlyNoDupes();    // fill in how many tests
      test_reverse();            // fill in how many tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
     System.out.print( "containsVowel test for Kevin: " );
     try { System.out.println( StringStuff.containsVowel("Kevin") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "containsVowel test for QWRTY: " );
     try { System.out.println( StringStuff.containsVowel("QWRTY") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
     System.out.print( "isPalindrome test for ABA: " );
     try { System.out.println( StringStuff.isPalindrome("ABA") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "isPalindrome test for ABBA: " );
     try { System.out.println( StringStuff.isPalindrome("ABBA") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "isPalindrome test for aBbA: " );
     try { System.out.println( StringStuff.isPalindrome("aBbA") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "isPalindrome test for AABA: " );
     try { System.out.println( StringStuff.isPalindrome("AABA") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
     System.out.print( "evensOnly test for ABCD: " );
     try { System.out.println( StringStuff.evensOnly("ABCD").equals("BD") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnly test for Aardvark: " );
     try { System.out.println( StringStuff.evensOnly("Aardvark").equals("rdvr") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnly test for ABAAAAAAAAAAC: " );
     try { System.out.println( StringStuff.evensOnly("ABAAAAAAAAAAC").equals("B") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnly test for KevinPatterson: " );
     try { System.out.println( StringStuff.evensOnly("KevinPatterson").equals("vnPttrn") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
     System.out.print( "oddsOnly test for ABCD: " );
     try { System.out.println( StringStuff.oddsOnly("ABCD").equals("AC") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnly test for Aardvark: " );
     try { System.out.println( StringStuff.oddsOnly("Aardvark").equals("Aaak") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnly test for ABAAAAAAAAAAC: " );
     try { System.out.println( StringStuff.oddsOnly("ABAAAAAAAAAAC").equals("AAAAAAAAAAAC") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnly test for Kevin Patterson: " );
     try { System.out.println( StringStuff.oddsOnly("KevinPatterson").equals("Keiaeso") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
     System.out.print( "evensOnlyNoDupes test for ABCD: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("ABCD").equals("BD") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnlyNoDupes test for Aardvark: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("Aardvark").equals("rdv") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnlyNoDupes test for ABAAAAAAAAAAC: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("ABAAAAAAAAAAC").equals("B") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "evensOnlyNoDupes test for KevinPatterson: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes("KevinPatterson").equals("vnPtr") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
     System.out.print( "oddsOnlyNoDupes test for ABCD: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("ABCD").equals("AC") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnlyNoDupes test for Aardvark: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("Aardvark").equals("Ak") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnlyNoDupes test for ABAAAAAAAAAAC: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("ABAAAAAAAAAAC").equals("AC") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "oddsOnlyNoDupes test for Kevin Patterson: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes("KevinPatterson").equals("Keiaso") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
     System.out.print( "reverse test for ABCD: " );
     try { System.out.println( StringStuff.reverse("ABCD").equals("DCBA") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "reverse test for KevinPatterson: " );
     try { System.out.println( StringStuff.reverse("KevinPatterson").equals("nosrettaPniveK") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "reverse test for racecar: " );
     try { System.out.println( StringStuff.reverse("racecar").equals("racecar") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "reverse test for Taco cat: " );
     try { System.out.println( StringStuff.reverse("Taco cat").equals("tac ocaT") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "reverse test for H E L L O W O R L D: " );
     try { System.out.println( StringStuff.reverse("H E L L O W O R L D").equals("D L R O W O L L E H") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

}
