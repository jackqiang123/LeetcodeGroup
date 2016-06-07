// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again)
public class Solution {
    public int maxProfit(int[] prices) {
      int buy1 = Integer.MIN_VALUE; int buy2 = Integer.MIN_VALUE;
      int sell1 = 0; int sell2 = 0;
      for (int p : prices){
        buy1 = Math.max(buy1, -p);
        sell1 = Math.max(sell1, buy1 + p);
        buy2 = Math.max(buy2, sell1 - p);
        sell2 = Math.max(sell2, buy2 + p);
      }
      return sell2;
    }
}
