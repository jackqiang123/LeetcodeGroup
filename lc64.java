// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
public class Solution {
    public int minPathSum(int[][] grid) {
      int h = grid.length;
      int w = grid[0].length;
      int [][]dp = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (i == 0 && j == 0) dp[i][j] = grid[i][j];
          else if (i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
          else if (j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
          else dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
        }
      }
      return dp[h-1][w-1];
    }
}
