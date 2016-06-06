// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] nums) {
      int i = 0;
      while(i < nums.length){
        if (nums[i] == i+1) i++;
        else if (nums[i] <= nums.length && nums[i] >= 1 && nums[nums[i]-1] != nums[i])
          swap(nums, i, nums[i]-1);
        else i++;
      }
      for (i = 0; i < nums.length; i++){
        if (nums[i] != i + 1) return i + 1;
      }
      return nums.length + 1;
    }
    private void swap(int[]nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
