/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Determine the minimum amount of coins needed to make a value
 * @author    :  Kevin Patterson
 * Date       :  2017-05-04
 * Description:  Uses loops and nested ifs to create and manipulate tuple values
                 until the program is able to figure out the most effecient combination
                 of coins
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-05-04  K. Patterson  Added in the code needed to make DynamicChangeMaker work properly.
                                     Thanks to BJ for the help on cracking the algorithm in class!
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangeMaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

    /**
     * Create a tuple (2d array) that will allow for the program to loop through
     * and slowly refine currency choices until the best breakdown of change is found.
     *
     * @param denominations an array of the different denominations of coin
     * @param amount the total money you are adding up to
     *
     * @return a Tuple that contains the most effecient breakdown of currency
     
     */

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
        Tuple[][] makeChange = new Tuple[ denominations.length ][ amount + 1 ];
        for( int i = 0; i < denominations.length; i++ ){
            for( int j = 0; j < amount + 1; j++ ){
              if(i == 0){
                if( j == 0 ){
                  makeChange[i][j] = new Tuple(denominations.length);
                }
                else if( j - denominations[i] < 0){
                  makeChange[i][j] = Tuple.IMPOSSIBLE;
                }
                else if( j - denominations[i] >= 0){
                  makeChange[i][j] = new Tuple(denominations.length);
                  if( j - denominations[i] == 0){
                    makeChange[i][j].setElement( i, 1);
                  }
                  if( j - denominations[i] > 0){
                    if(makeChange[i][ j - denominations[i] ].isImpossible() ){
                      makeChange[i][j] = Tuple.IMPOSSIBLE;
                    }
                    else{
                      makeChange[i][j].setElement( i, 1);
                      makeChange[i][j] = makeChange[i][j].add( makeChange[i][ j - denominations[i] ] );
                    }
                  }
                }
              }
              else {
                if( j == 0 ){
                  makeChange[i][j] = new Tuple(denominations.length);
                }
                else if( j - denominations[i] < 0){
                  if( makeChange[ i - 1 ][j].isImpossible() ){
                    makeChange[i][j] = Tuple.IMPOSSIBLE;
                  }
                  else {
                    makeChange[i][j] = new Tuple(denominations.length);
                    makeChange[i][j] = makeChange[i][j].add( makeChange[ i-1 ][j] );
                  }
                }
                else if( j - denominations[i] >= 0){
                  makeChange[i][j] = new Tuple(denominations.length);
                  if( j - denominations[i] == 0){
                    makeChange[i][j].setElement( i, 1);
                  }
                  if( j - denominations[i] > 0){
                    if(makeChange[i][ j - denominations[i] ].isImpossible() ){
                      if(makeChange[ i - 1 ][j].isImpossible() ){
                        makeChange[i][j] = Tuple.IMPOSSIBLE;
                      }
                      else {
                        makeChange[i][j] = makeChange[ i - 1 ][j];
                      }
                    }
                    else{
                      makeChange[i][j].setElement( i, 1);
                      makeChange[i][j] = makeChange[i][j].add( makeChange[i][ j - denominations[i] ] );
                      if( makeChange[i][j].total() > makeChange[ i - 1 ][j].total() && makeChange[ i - 1 ][j].isImpossible() == false ){
                        makeChange[i][j] = makeChange[ i - 1 ][j];
                      }
                    }
                  }
                }
              }
            }
        }
        return makeChange[ (denominations.length - 1) ][ amount ];
    }

    private static void printUsage() {
        System.out.println("Usage: java DynamicChangeMaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
