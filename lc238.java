// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
// all the elements of nums except nums[i].
//
// Solve it without division and in O(n).
//
// For example, given [1,2,3,4], return [24,12,8,6].
public class Solution {
    public int[] productExceptSelf(int[] nums) {
      int len = nums.length;
      int []left = new int[len];
      int []right = new int[len];
      for (int i = 0; i < len; i++){
        if (i == 0) left[0] = 1;
        else left[i] = left[i-1]*nums[i-1];
      }
      for (int i = len - 1; i >= 0; i--){
        if (i == len - 1) right[i] = 1;
        else right[i] = right[i+1]*nums[i+1];
      }
      for (int i = 0; i < len; i++)
      {
        left[i] *= right[i];
      }
      return left;
    }
}
