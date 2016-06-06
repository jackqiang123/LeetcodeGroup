// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class Solution {
    public boolean isMatch(String s, String p) {
      int slen = s.length();
      int plen = p.length();
      boolean[][]dp = new boolean[slen+1][plen+1];// whether 0...i matches 0...j
      dp[0][0] = true;
      for (int j = 1; j <= plen; j++){
        dp[0][j] = dp[0][j-1] && p.charAt(j-1) == '*';
      }
      for (int i = 1; i <= slen; i++){
        for (int j = 1; j <= plen; j++){
            dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?');
            if (dp[i][j]) continue;
            if (p.charAt(j-1) == '*'){
              for (int k = i; k >= 0; k--){
                if (dp[k][j-1])     {
                    dp[i][j] = dp[k][j-1]; break;

                }
              }
            }
        }
      }
      return dp[slen][plen];
    }
}
