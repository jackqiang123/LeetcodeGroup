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
          tab[i][j] = s.charAt(i) == s.charAt(j) && (j-i>=2 || tab[i+1][j-1]);
        }
      }
      return dfs(0, len - 1, tab);
    }

    private int dfs(int start, int end, boolean[][] tab){
      if (tab[start][end]) return 0;
      int curBest = Integer.MAX_VALUE;
      for (int i = start; i < end; i++){
        curBest = Math.min(curBest, dfs(start,i,tab) + dfs(i+1,end,tab));
      }
      return curBest;
    }
}
