// Given an integer matrix, find the length of the longest increasing path.
//
// From each cell, you can either move to four directions: left, right, up or down.
// You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
// Example 1:
//
// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].
//
// Example 2:
//
// nums = [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
public class Solution {
      int res;int [][]dp;
    public int longestIncreasingPath(int[][] matrix) {
      res = 0;
      int h = matrix.length;
      if (h == 0) return res;
      int w = matrix[0].length;
      dp = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          dp[i][j] = dfs(matrix, i, j, Integer.MIN_VALUE);
          res = Math.max(res, dp[i][j]);
        }
      }
      return res;
    }
    private int dfs(int[][]matrix, int i, int j, int base){
      if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= base) return 0;
      if (dp[i][j] != 0) return dp[i][j];
      dp[i][j] = 1;
      int left = dfs(matrix, i - 1, j, matrix[i][j]);
      int right = dfs(matrix, i + 1, j, matrix[i][j]);
      int top = dfs(matrix, i , j - 1, matrix[i][j]);
      int bottom = dfs(matrix, i , j + 1, matrix[i][j]);
      dp[i][j] += Math.max(Math.max(left, right), Math.max(top, bottom));
      return dp[i][j];
    }
}
