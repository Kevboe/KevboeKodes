import java.util.*;

public class GinormousInt {

  private ArrayList<Integer> big1 = new ArrayList<Integer>();
  private static final int CARRY = 1;
  public static final int ZERO = 0;
  public static final int ONE = 1;
  public static final int TEN = 10;

  public GinormousInt( String gInt ) {
   for(int x = 0; x < gInt.length(); x++){
     big1.add(Integer.parseInt(String.valueOf(gInt.charAt(x))));
   }
  }

  public int get(int x){
    return big1.get(x);
  }

  public int size(){
    return big1.size();
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
*/
