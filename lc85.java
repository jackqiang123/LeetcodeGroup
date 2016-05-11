// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
public class Solution {
    public int maximalRectangle(char[][] matrix) {
      int h = matrix.length;
      int w = matrix[0].length;
      int [][]dp = new int[h][w]; // the rectangle length, with right bottom vertice fixed.
      int res = 0;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (matrix[i][j] == '1'){
            if (i == 0 || j == 0) dp[i][j] = 1;
            else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
          }
          res = Math.max(res, dp[i][j]);
        }
      }
      return res*res;
    }
}
