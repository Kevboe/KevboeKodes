import java.util.*;

public class GinormousInt {

  private ArrayList<Integer> big1 = new ArrayList<Integer>();
  private ArrayList<Integer> afterMath = new ArrayList<Integer>();
  private int carry;
  public static final int ZERO = 0;
  public static final int ONE = 1;
  public static final int TEN = 10;

  public GinormousInt( String gInt ) {
   for(int x = 0; x < gInt.length(); x++){
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

  public GinormousInt addInt( GinormousInt big2 ) {
    carry = 0;
    int digitDif = 0;
    if ( big1.compareTo( big2 ) == -1 ){
      digitDif = big2.size() - big1.size();
      for ( int x = big1.size() - 1; x > 0; x-- ) {

        if ( ( big1.get( x ) + big2.get( x + digitDif ) + carry ) >= 10 ){
          afterMath.add( ( ( big1.get( x ) + big2.get( x ) + carry ) % 10 ), 0 )
          carry = 1;
        }

        if ( ( big1.get( x ) + big2.get( x + digitDif ) + carry ) < 10 ){
          afterMath.add( ( ( big1.get( x ) + big2.get( x ) + carry ) % 10 ), 0 )
          carry = 0;
        }
      }
      for ( int x = digitDif - 1;  x > 0; x-- ){
        if ( big2.get( x ) + carry >= 10 ){
          afterMath.add( ( big2.get( x ) + carry ) % 10 ), 0 )
          carry = 1;
        }
        if ( big2.get( x ) + carry < 10 ){
          afterMath.add( ( big2.get( x ) + carry ) % 10 ), 0 )
          carry = 0;
        }
      }
    }
    if ( big1.compareTo( big2 ) == 1 ){
      for ( int x = big2.size(); x > 0; x-- ) {
        // copy and change code from one part of add isntance to other sections
      }
    }
    if ( big1.compareTo( big2 ) == -0 ){
      for ( int x = big2.size(); x > 0; x-- ) {
        // copy and change code from one part of add isntance to other sections
      }
    }
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
