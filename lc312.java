// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//
// Find the maximum coins you can collect by bursting the balloons wisely.
//
// Note:
// (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
// (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
// Example:
//
// Given [3, 1, 5, 8]
//
// Return 167
//
//    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

// remark, if in dp, we will need to compute first inside, then outside
// then we will need to let i start from end to decrease, while j from i to increase
public class Solution {
    public int maxCoins(int[] nums) {
      int len = nums.length;
      int [][]dp = new int[len+2][len+2];
      // the max keeping boundary i, j
      // dp[i][j] = dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j]
      // assume k is the last one to break.
      for (int i = len + 1; i >= 0; i--){
        for (int j = i + 2; j <= len + 1; j++){
          dp[i][j] = Integer.MIN_VALUE;
          for (int k = i + 1; k < j; k++){
              dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + (i-1>=0?nums[i-1]:1)*nums[k-1]*(j-1<len?nums[j-1]:1));
          }
        }
      }
      return dp[0][len+1];
    }
}
