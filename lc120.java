// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int h = triangle.size();
      int w = triangle.get(h-1).size();
      int [][] dp = new int[h][w];
      for (int i = h - 1; i >= 0; i--){
        for (int j = 0; j < triangle.get(i).size(); j++){
          dp[i][j] = triangle.get(i).get(j);
          if (i != h - 1) {
            dp[i][j] += Math.min(dp[i+1][j], dp[i+1][j+1]);
          }
        }
      }
      return dp[0][0];
    }
}
