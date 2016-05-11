// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
//
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
// The number of ways decoding "12" is 2.
public class Solution {
    public int numDecodings(String s) {
      int len = s.length();
      int []dp = new int[len];
      int i = 1;
      dp[0] = 1;
      while(i<len){
        char c = s.charAt(i);
        if (c == '0'){
          if (i == 0 || (s.charAt(i-1) != '1' && s.charAt(i-1) != '2'))
            return 0;
          else if (i == 1)
            dp[i] = 1;
          else dp[i] = dp[i-2];
        }
        else if (i <= '6' && i >= '1'){

        }
        else { // 9 >= i >=7 

        }
      }
      return dp[dp.length - 1];
    }
}
