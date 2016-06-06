// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
// Write a function to determine if a given target is in the array.
public class Solution {
    public boolean search(int[] nums, int target) {
      int lo = 0;
      int hi = nums.length - 1;
      while(lo < hi){
        int mid = (lo + hi)/2;
        if (nums[mid] == target) return true;
        if (nums[mid] < nums[hi]){
          if (nums[hi] >= target && nums[mid] < target){
            lo = mid + 1;
          }else hi = mid;
        }
        else if (nums[mid] > nums[hi]){
          if (nums[mid] > target && nums[lo] <= target)
            hi = mid;
          else lo = mid + 1;
        }
        else hi--;
      }
      return nums[lo] == target;
    }
}
