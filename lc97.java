// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int len1 = s1.length();
      int len2 = s2.length();
      int len3 = s3.length();
      if (len1 + len2 != len3) return false;
      boolean [][]dp = new boolean[len1 + 1][len2 + 1];//0..i-1, 0...j-1 interleavaes
      for (int i = 0; i <= len1; i++){
        for (int j = 0; j <= len2; j++)
        {
          if (i == 0 && j == 0) dp[i][j] = true;
          else if (i == 0) dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
          else if (j == 0) dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
          else {
            int s3index = i + j - 1;
            if (s1.charAt(i-1) == s3.charAt(s3index) && dp[i-1][j])
              dp[i][j] = true;
            if (s2.charAt(j-1) == s3.charAt(s3index) && dp[i][j-1])
              dp[i][j] = true;
          }
      }
    }
     return dp[len1][len2];
}
}
