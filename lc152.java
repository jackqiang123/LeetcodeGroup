// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.
public class Solution {
    public int maxProduct(int[] nums) {
      int len = nums.length;
      int []min = new int[len];
      int []max = new int[len];
      int res = nums[0];
      min[0] = nums[0];
      max[0] = nums[0];
      for (int i = 1; i < len; i++){
        min[i] = Math.min(nums[i], Math.min(nums[i]*min[i-1], nums[i]*max[i-1]));
        max[i] = Math.max(nums[i], Math.max(nums[i]*min[i-1], nums[i]*max[i-1]));
        res = Math.max(res, max[i]);
      }
      return res;
    }
}
