// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
// find the one that is missing from the array.
//
// For example,
// Given nums = [0, 1, 3] return 2.
//
public class Solution {
    public int missingNumber(int[] nums) {
      int i = 0;
      while(i < nums.length){
        if (nums[i] == i){
          i++;
        }
        else{
          if (nums[i] >= 0 && nums[i] < nums.length){
            if (nums[nums[i]] == nums[i]) {i++;}
            else swap(nums, i, nums[i]);
          }
          else i++;
        }
      }
      for (i = 0; i < nums.length; i++){
        if (nums[i] != i) return i;
      }
      return nums.length;
    }
    private void swap(int[]nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
