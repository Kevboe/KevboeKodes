/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  GinormousInt.java
 * Purpose    :  Test Harness for the GinormousInt java class
 * @author    :  Kevin Patterson
 * Date       :  2017-04-05
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-16  K. Patterson  Initial writing
 *  1.1.0  2017-04-17  K. Patterson  Creating add/sub/mult
 *
 */

import java.util.*;

public class GinormousInt {

  private ArrayList<Integer> big1 = new ArrayList<Integer>();
  private ArrayList<Integer> afterMath = new ArrayList<Integer>();
  private int carry;
  private boolean negative;
  public static final int ZERO = 0;
  public static final int ONE = 1;
  public static final int TEN = 10;

  public GinormousInt( String gInt ) {
    //Trying to make negative numbers work in GinormousInt
    negative = false;
    if ( gInt.contains("-") ){
      gInt.replaceAll( "-", "" );
      negative = true;
    }
   for(int x = 0; x < gInt.length(); x++){
     if( negative == true && x == 0 ){
       big1.add( -1 * (Integer.parseInt( String.valueOf( gInt.charAt( x ) ) ) ) );
       x++;
     }
     big1.add( Integer.parseInt( String.valueOf( gInt.charAt( x ) ) ) );
   }
   carry = 0;
  }

  public int get( int x ){
    return big1.get( x );
  }

  public int size(){
    return big1.size();
  }

  public void add(int pos, int x){
    big1.add( pos, x );
  }

  public int compareTo( GinormousInt big2){
    int rtrnSize = 0;
    if( big1.size() > big2.size() ){
      rtrnSize = 1;
      return rtrnSize;
    }
    if( big1.size() < big2.size() ){
      rtrnSize = -1;
      return rtrnSize;
    }
    if( big1.size() ==  big2.size() ){
      for( int x = 0; x < big1.size(); x++ ){
        if( big1.get( x ) > big2.get( x ) ){
          rtrnSize = 1;
          return rtrnSize;
        }
        if( big1.get(x) < big2.get( x ) ){
          rtrnSize = -1;
          return rtrnSize;
        }
      }
    }
    return rtrnSize;
  }

  public String addInt( GinormousInt big2 ) {
    afterMath.clear();
    carry = 0;
    int digitDif = 0;
    int sum = 0;
    if ( big1.size() < big2.size() ){
      digitDif = big2.size() - big1.size();
      for ( int x = big1.size() - 1; x >= 0; x-- ) {
        sum = big1.get( x ) + big2.get( x + digitDif ) + carry;
        if ( sum > 9 ){
          afterMath.add( 0, ( sum % 10 ) );
          carry = 1;
        }
        if ( sum < 10 ){
          afterMath.add( 0, ( sum % 10 ) );
          carry = 0;
        }
      }
      for ( int x = digitDif - 1;  x >= 0; x-- ){
        if ( big2.get( x ) + carry >= 10 ){
          afterMath.add( 0, ( ( big2.get( x ) + carry ) % 10 ) );
          carry = 1;
        }
        if ( big2.get( x ) + carry < 10 ){
          afterMath.add( 0, ( ( big2.get( x ) + carry ) % 10 ) );
          carry = 0;
        }
      }
    }

    if ( big1.size() > big2.size() ){
      digitDif = big1.size() - big2.size();
      for ( int x = big2.size() - 1; x >= 0; x-- ) {
        sum = big1.get( x + digitDif ) + big2.get( x ) + carry;
        if ( sum > 9 ){
          afterMath.add( 0, ( sum % 10 ) );
          carry = 1;
        }
        if (sum < 10 ){
          afterMath.add( 0, (sum % 10 ) );
          carry = 0;
        }
      }
      for ( int x = digitDif - 1;  x >= 0; x-- ){
        if ( big1.get( x ) + carry >= 10 ){
          afterMath.add( 0, ( ( big1.get( x ) + carry ) % 10 ) );
          carry = 1;
        }
        if ( big1.get( x ) + carry < 10 ){
          afterMath.add( 0, ( ( big1.get( x ) + carry ) % 10 ) );
          carry = 0;
        }
      }
    }

    if ( big1.size() == big2.size() ){
      for ( int x = big2.size() - 1; x >= 0; x-- ) {
        if ( ( big1.get( x ) + big2.get( x ) + carry ) >= 10 ){
          afterMath.add( 0, ( ( big1.get( x ) + big2.get( x ) + carry ) % 10 ) );
          carry = 1;
        }
        if ( ( big1.get( x ) + big2.get( x ) + carry ) < 10 ){
          afterMath.add( 0, ( ( big1.get( x ) + big2.get( x ) + carry ) % 10 ) );
          carry = 0;
        }
      }
    }
    String rtrn = "";
    for( int i : afterMath ){
      rtrn += i;
    }
    return rtrn;
  }

  public String subtractInt( GinormousInt big2 ) {
    //More time: Make it so negatives work 1 negative = addition 2 negatives = still subtraction
    //Idea: Manipulate the ints independant of negatives then add 1 if needed at the end
    //Can't implement due to time constraints
    afterMath.clear();
    int digitDif = 0;
    int dif = 0;
    int borrow = 0;
    int rtrnSize = 0;
    if ( big1.size() < big2.size() ){
      digitDif = big2.size() - big1.size();
      for ( int x = big1.size() - 1; x >= 0; x-- ) {
        dif = ( big2.get(x) - borrow ) - big1.get(x);
        if ( dif < 0 ){
          afterMath.add( 0, ( 10 - dif ) );
          borrow = 1;
        }
        afterMath.add( 0, ( dif) );
        carry = 0;
      }
      for ( int x = digitDif - 1;  x >= 0; x-- ){
        dif = big2.get(x) - borrow;
        if ( dif < 0 ){
          afterMath.add( 0, ( 10 - dif ) );
          borrow = 1;
        }
        afterMath.add( 0, ( dif) );
        carry = 0;
      }
    }

    if ( big1.size() > big2.size() ){
      digitDif = big1.size() - big2.size();
      for ( int x = big2.size() - 1; x >= 0; x-- ) {
        dif = ( big1.get(x) - borrow ) - big2.get(x);
        if ( dif < 0 ){
          afterMath.add( 0, ( 10 - dif ) );
          borrow = 1;
        }
        afterMath.add( 0, ( dif) );
        carry = 0;
      }
      for ( int x = digitDif - 1;  x >= 0; x-- ){
        dif = big1.get(x) - borrow;
        if ( dif < 0 ){
          afterMath.add( 0, ( 10 - dif ) );
          borrow = 1;
        }
        afterMath.add( 0, ( dif) );
        carry = 0;
      }
    }

    if ( big1.size() == big2.size() ){
      for( int x = 0; x < big1.size(); x++ ){
        if( big1.get( x ) > big2.get( x ) ){
          rtrnSize = 1;
          break;
        }
        if( big1.get(x) < big2.get( x ) ){
          rtrnSize = -1;
          break;
        }
      }
      if ( big1.equals( big2 ) == true ){
        afterMath.add( 0 );
      }
      if ( rtrnSize == -1 ){
        for ( int x = big2.size() - 1; x >= 0; x-- ) {
          dif = ( big2.get(x) - borrow ) - big1.get(x);
          if ( dif < 0 ){
            afterMath.add( 0, ( 10 - dif ) );
            borrow = 1;
          }
          afterMath.add( 0, ( dif) );
          carry = 0;
          }
        }
        if ( rtrnSize == 1 ){
          for ( int x = big1.size() - 1; x >= 0; x-- ) {
            dif = ( big1.get(x) - borrow ) - big2.get(x);
            if ( dif < 0 ){
              afterMath.add( 0, ( 10 - dif ) );
              borrow = 1;
            }
            afterMath.add( 0, ( dif) );
            carry = 0;
          }
        }
      }
    String rtrn = "";
    for( int i : afterMath ){
      rtrn += i;
    }
    return rtrn;
  }

  public boolean equals( GinormousInt big2){
    boolean isEqual = true;
     if( big2.size() != big1.size() ){
       isEqual = false;
       return isEqual;
     }
     for(int x = 0; x < big1.size(); x++){
       if( big1.get(x) != big2.get(x) ){
         isEqual = false;
         return isEqual;
       }
     }
     return isEqual;
  }

  public String toString(){
    String rtrn = "";
    for( int i : big1 ){
      rtrn += i;
    }
    return rtrn;
  }

  // public static void main( String[] Args){
  //   throw new UnsupportedOperationException();
  //}

}

/* notes and thoughts
Array list of integers
for loop to go through and access numbers
make sure toString doesn't include the commas. makes it just the numbers!!
Multiplication is just repetitive addition
Multiplication:
1234 * 567 = 1234 * 7 + 1234 * 60 + 1234 * 500 = answer
result 1 + result 2 = total
result 1 = total
result 2 = base # * next number in bottom list and add() 0s
*/
