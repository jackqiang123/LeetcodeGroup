// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
//
// Note: you may assume that n is not less than 2.
//
// Hint:
//
// There is a simple O(n) solution to this problem.
// You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
public class Solution {
    public int integerBreak(int n) {
      if (n == 2) return 1;
      if (n == 3) return 2;
      int [] dp = new int[n+1];
      dp[1] = 1;
      dp[2] = 2;
      dp[0] = 1;
      for (int i = 3; i <= n; i++){
        dp[i] = Math.max(2*dp[i-2], 3*dp[i-3]);
      }
      return dp[n];
    }
}
