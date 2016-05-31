// Additive number is a string whose digits can form additive sequence.
//
// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
// For example:
// "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//
// "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
//
// 1 + 99 = 100, 99 + 100 = 199
//
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
//
// Follow up:
// How would you handle overflow for very large input integers?
import java.math.BigInteger;
public class Solution {
 public boolean isAdditiveNumber(String num) {
   return dfs(num, 0, new ArrayList<Long>());
 }
 private boolean dfs(String num, int start, List<Long> cur){
   if (start == num.length()){
     return cur.size() >= 3;
   }
   else {
      if (cur.size() >= 2){
       int size = cur.size();
       String target = String.valueOf(cur.get(size - 1) + cur.get(size - 2));
       if (start + target.length() <= num.length() && target.equals(num.substring(start, start+target.length()))){
         cur.add(cur.get(size - 1) + cur.get(size - 2));
         if (dfs(num, start + target.length(), cur))
           return true;
         cur.remove(cur.size() - 1);
         return false;
       }
       else{
         return false;
       }
     }
     else{
       for (int i = start + 1; i <= num.length() && i - start <= 10; i++){
         String s = num.substring(start, i);
         cur.add(Long.parseLong(s));
         if (dfs(num, i, cur)){
           return true;
         }
         cur.remove(cur.size()-1);
         if (num.charAt(start) == '0') break;
       }
       return false;
     }
   }
 }
}
