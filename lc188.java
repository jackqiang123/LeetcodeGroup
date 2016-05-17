// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most k transactions.
//
// Note:
// You may not engage in multiple transactions at the same time
//  (ie, you must sell the stock before you buy again).
public class Solution {
    public int maxProfit(int K, int[] prices) {
      // add speical case handle
      // when K >= prices.length/2
      int[][]dp = new int[K+1][prices.length+1];
      //do transcation k at day i
      for (int i = 0; i <= K; i++){
        for (int j = 0; j <= prices.length; j++)
        {
          if (i == 0 || j == 0) dp[i][j] = 0;
          else {
            for (int l = 1; l <= j; l++)
            {
              dp[i][j] = Math.max(dp[i][j], dp[i-1][l] + prices[j-1] - prices[l-1]);
            }
          }
        }
      }
      return dp[K][prices.length];
    }
}
