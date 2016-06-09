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
      if (s.length() == 0) return s;
      String ss = s + " " + (new StringBuilder(s).reverse()) + "#";
      int[]next = getNextArray(ss);
      int lengthofSP = next[next.length - 1];
      return (new StringBuilder(s.substring(lengthofSP)).reverse()) + s;
    }
    private int[]getNextArray(String s){
      int []next = new int[s.length()];
      int j = 0;
      int k = -1;
      next[0] = -1;
      while(j < s.length() - 1){
        if (k == -1 || s.charAt(j) == s.charAt(k)){
          next[++j] = ++k;
        }
        else {
          k = next[k];
        }
      }
      return next;
    }


}
