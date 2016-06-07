// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
      int len = prices.length;
      if (len <= 1) return 0;
      int res = 0;
      int low = prices[0];
      for (int i = 1; i < len; i++){
        res = Math.max(res, prices[i] - low);
        low = Math.min(low, prices[i]);
      }
      return res;
    }
}
