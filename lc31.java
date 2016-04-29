// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place, do not allocate extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

public class Solution {
    public void nextPermutation(int[] nums) {
      int len = nums.length;
      if (len == 1) return;
      int i = len - 1;
      while(i >= 1){
        if (nums[i] <= nums[i-1]) i--;
        else break;
      }
      if (i == 0) {Arrays.sort(nums); return;}
      int j = findMininRange(nums, nums[i-1], i);
      swap(nums, i-1, j);
      Arrays.sort(nums,i,nums.length);
    }

    private void swap(int nums[], int i, int j){
      int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }

    private int findMininRange(int [] nums, int target, int start){
      int len = nums.length;
      for (int i = len - 1 ; i >= 0; i--){
        if (nums[i] > target) return i;
      }
      return -1;
    }
}
