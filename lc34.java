// Given a sorted array of integers, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

public class Solution {
    public int[] searchRange(int[] nums, int target) {
      int len = nums.length;
      int res [] = new int []{-1,-1};
      if (len == 0) return res;
      int lo = 0;
      int hi = len - 1;
      while(lo < hi){
        int mid = (lo + hi)/2;
        if (nums[mid] < target) lo = mid + 1;
        else hi = mid;
      }
      if (nums[lo] != target) return res;
      res[0] = lo; res[1] = lo;
      hi = len - 1;
      while (lo < hi){
        int mid = (lo + hi)/2;
          if (nums[mid] > target) hi = mid;
          else lo = mid + 1;
      }
      res[1] = nums[hi] == target ? hi : hi - 1;
      return res;
    }
}
