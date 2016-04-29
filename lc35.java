// Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class Solution {
    public int searchInsert(int[] nums, int target) {
      if (nums.length == 0) return 0;
      int lo = 0;
      int hi = nums.length - 1;
      while(lo < hi){
        int mid = (lo + hi)/2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) lo = mid + 1;
        else hi = mid;
      }
      if(nums[lo] == target) return lo;
      return nums[lo] > target ? lo : lo + 1;
    }
}
