// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB
// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases.
public class Solution {
    public String convertToTitle(int n) {
      StringBuilder sb = new StringBuilder();
      while(n != 0){
        n--;
        int cur = n%26;
        char c = (char)('A' + cur);
        sb.insert(0, c);
        n = n/26;
      }
      return sb.toString();
    }
}
