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
      if (len == 0) return 0;
      int []dp = new int[len];//the interprating way at position i
      dp[0] = s.charAt(0) != '0' ? 1:0;
      if(dp[0] == 0) return 0;
      int i = 1;
      while(i<len){
        char c = s.charAt(i);
        if(c == '0'){
           if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
             dp[i] = i-2 >= 0 ? dp[i-2] : 1;
           }
           else return 0;
        }
        else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && c <= '6')){
             dp[i] = dp[i-1] + (i-2>=0?dp[i-2]:1);
        }
        else {
            dp[i] = dp[i-1];
        }
        i++;
      }
      return dp[dp.length - 1];
    }
}
