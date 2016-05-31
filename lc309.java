// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//
// Example:
//
// prices = [1, 2, 3, 0, 2]
// maxProfit = 3
// transactions = [buy, sell, cooldown, buy, sell]
public class Solution {
    public int maxProfit(int[] p) {
      int len = p.length;
      if (len <= 1) return 0;
      int []sell = new int[len];
      int []rest = new int[len];
      sell[1] = p[1] - p[0];
      for (int i = 2; i < len; i++){
        rest[i] = Math.max(rest[i-1], sell[i-1]);
        sell[i] = p[i] - p[i-1] + Math.max(sell[i-1], rest[i-2]);
        // sell i is equal to buy and sell at i-1 additive based on p[i] - p[i-1], that is we are not sell/buy stock at day i-1
        // or newly break at position i-2
      }
      return Math.max(rest[len-1], sell[len-1]);
    }
}
