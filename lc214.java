// Given a string S, you are allowed to convert it to a palindrome by adding characters
// in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
// For example:
//
// Given "aacecaaa", return "aaacecaaa".
//
// Given "abcd", return "dcbabcd".
public class Solution {
    public String shortestPalindrome(String s) {
      StringBuilder sb;
      int len = s.length();
      for (int i = 0; i < len; i++){
        sb = new StringBuilder(s);
        for (int j = 0; j <= i; j++){
          sb.insert(len, s.charAt(j));
        }
        if (isPalindrome(sb))
          return sb.toString();
      }
      return null;
    }

    private boolean isPalindrome(StringBuilder s){
      int i = 0; int j = s.length() - 1;
      while(i < j){
        if (s.charAt(i) != s.charAt(j)) return false;
        i++; j--;
      }
      return true;
    }
}
