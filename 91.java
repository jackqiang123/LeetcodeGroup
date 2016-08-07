// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
// The number of ways decoding "12" is 2.
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        return helper(s);
    }
    private int helper(String s){

      if (s.length() == 0) return 1;
      if (s.length() == 1)  {
          if (s.charAt(0) == '0') return 0;
          else return 1;
      }
      char c = s.charAt(0);
      char next = s.charAt(1);
      if (c == '0') return 0;
      if (c != '1' && c != '2') return helper(s.substring(1));
      if (next == '0') {
        if (c != '1' && c != '2') return 0;
        return helper(s.substring(2));
      }
      else if (c == '1'){
        return helper(s.substring(1)) + helper(s.substring(2));
      }
      else if (c == '2'){
        if (next <= '6') return helper(s.substring(1)) + helper(s.substring(2));
        else return helper(s.substring(1));
      }
      else return helper(s.substring(1));
    }

}
