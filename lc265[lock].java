// here are a row of n houses, each house can be painted with one of the k colors.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the same color.
//
// The cost of painting each house with a certain color is represented by a n x k cost matrix.
// For example, costs[0][0] is the cost of painting house 0 with color 0;
// costs[1][2] is the cost of painting house 1 with color 2, and so on...
// Find the minimum cost to paint all houses.
//
// Note:
// All costs are positive integers.
//
// Follow up:
// Could you solve it in O(nk) runtime?
public class Solution {
    public int minCostII(int[][] costs) {
        int [][] dp = new int[costs.length][costs[0].length];
        int collen = costs[0].length;
        int lastMinIndex = 0;
        int lastSecMinIndex = 0;
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < collen; j++){
              if (i == 0)   dp[i][j] = costs[i][j]; 
              else if (j != lastMinIndex) dp[i][j] = costs[i][j] + dp[i-1][lastMinIndex];
              else dp[i][j] = costs[i][j] + dp[i-1][lastSecMinIndex];
              if (dp[i-1][j] < dp[i-1][lastMinIndex]){
                lastMinIndex = j;
              }
              else if (dp[i-1][j] < dp[i-1][lastSecMinIndex] && j != lastMinIndex){
                lastSecMinIndex = j;
              }
          }
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < collen; j++)
          minCost = Math.min(minCost, dp[dp.length - 1][j]);
        return minCost;
    }
  }
