// You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint
// stopping you from robbing each of them is that adjacent houses have
// security system connected and it will automatically contact the police
// if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the
// amount of money of each house, determine the maximum amount of money
// you can rob tonight without alerting the police.
public class Solution {
    public int rob(int[] nums) {
      int len = nums.length;
      if (len == 0) return 0;
      if (len == 1) return nums[0];
      int max = nums[0];
      int []dp = new int[len];
      for(int i = 0; i < len; i++){
        if (i == 0) dp[i] = nums[i];
        else if (i == 1) dp[i] = Math.max(nums[0], nums[1]);
        else {
          dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        max = Math.max(max, dp[i]);
      }
      return max;
    }
}
