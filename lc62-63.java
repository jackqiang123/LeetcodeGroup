// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
//
// Note: m and n will be at most 100.
public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
      int h = grid.length;
      if (h == 0) return 0;
      int w = grid[0].length;
      int [][]dp = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++)
        {
          if (grid[i][j] == 1) {dp[i][j] = 0;continue;}
          if (i == 0 && j == 0) dp[i][j] = 1;
          else if (i == 0) dp[i][j] = dp[i][j-1] == 1 ? 1 : 0;
          else if (j == 0) dp[i][j] = dp[i-1][j] == 1 ? 1 : 0;
          else dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
      return dp[h-1][w-1];
    }
}
