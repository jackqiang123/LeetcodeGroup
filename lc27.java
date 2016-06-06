// Given an array and a value, remove all instances of that value in place and return the new length.
//
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
// Example:
// Given input array nums = [3,2,2,3], val = 3
//
// Your function should return length = 2, with the first two elements of nums being 2.

public class Solution {
    public int removeElement(int[] nums, int val) {
      int len = nums.length;
      if (len == 0) return 0;
      int i = 0;
      int end = len - 1;
      while(i <= end){
        if (nums[i] == val){
          swap(nums, i, end--);
        }else i++;
      }
      return i;
    }
    private void swap(int []nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
