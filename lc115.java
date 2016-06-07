// Given a string S and a string T, count the number of distinct subsequences of T in S.
//
// A subsequence of a string is a new string which is formed from the original string by
// deleting some (can be none) of the characters without disturbing the relative positions of
// the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
// Here is an example:
// S = "rabbbit", T = "rabbit"
//
// Return 3.

public class Solution {
    public int numDistinct(String s, String t) {
      int slen = s.length();
      int tlen = t.length();
      int [][]dp = new int [slen+1][tlen+1];
      for (int i = 0; i <= slen; i++)
        dp[i][0] = 1;
      for (int i = 1; i <= slen; i++){
        for (int j = 1; j <= tlen; j++){
          dp[i][j] = dp[i-1][j] + (s.charAt(i-1) == t.charAt(j-1) ? dp[i-1][j-1] : 0);
        }
      }
      return dp[slen][tlen];
    }
}
