// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
          Arrays.sort(nums);
          int len = nums.length;
          int res = nums[0] + nums[1] + nums[2];
          int distance = Math.abs(res - target);
          for (int i = 0; i < len; i++){
            int lo = i + 1;
            int hi = len - 1;
            while(lo < hi){
              int sum = nums[i] + nums[lo] + nums[hi];
              if (Math.abs(res - target) > Math.abs(sum - target)) {
                res = sum;
                distance = Math.abs(res - target);
              }
              if (sum > target) hi--;
              else if (sum <target) lo++;
              else return target;
            }
          }
          return res;
    }
}
