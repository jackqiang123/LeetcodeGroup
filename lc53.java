// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.
public class Solution {
    public int maxSubArray(int[] nums) {
      int len = nums.length;
      int curBest = nums[0];
      int lastSum = Math.max(0, curBest);
      for (int i = 1; i < len; i++){
        curBest = Math.max(curBest, nums[i] + lastSum);
        lastSum = Math.max(0, lastSum + nums[i]);
      }
      return curBest;
    }
}
