// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class Solution {
    public int minCut(String s) {
      int len = s.length();
      if (len <= 1) return 0;
      boolean [][]tab = new boolean[len][len];
      for (int i = len - 1; i >= 0; i--){
        for (int j = i; j < len; j++)
        {
          tab[i][j] = s.charAt(i) == s.charAt(j) && (j-i<=2 || tab[i+1][j-1]);
        }
      }
      int dp[] = new int[len];
      for (int i = 0; i < len; i++){
        if (i == 0) dp[0] = 0;
        else if (tab[0][i]) dp[i] = 0;
        else {
          dp[i] = i;
          for (int j = 0; j < i; j++){
            if (tab[j+1][i])
              dp[i] = Math.min(dp[i], 1 + dp[j]);
          }
        }
      }
      return dp[len - 1];
    }
}
