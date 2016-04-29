// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] nums, int target) {
      int lo = 0;
      int hi = nums.length - 1;
      while(lo < hi){
        int mid = (lo + hi)/2;
        if (nums[mid] == target) return mid;
        if (nums[hi] > target && nums[mid] < target){
          lo = mid + 1;
        }else hi = mid;
      }
      return nums[lo] == target ? lo : - 1;
    }
}
