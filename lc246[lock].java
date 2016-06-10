// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to determine if a number is strobogrammatic. The number is represented as a string.
public class Solution{
  public boolean isStrobogrammatic(String n){
    Map<Character, Character> map = new HashMap();
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');
    map.put('6', '9');
    map.put('9', '6');
    int i = 0; int j = n.length() - 1;
    while(i <= j){
      char left = n.charAt(i);
      if (n.charAt(j) == map.get(left)){i++; j--;}
      else return false;
    }
    return true;
  }
}
