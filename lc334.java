// Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
//
// Formally the function should:
// Return true if there exists i, j, k
// such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
// Your algorithm should run in O(n) time complexity and O(1) space complexity.
//
// Examples:
// Given [1, 2, 3, 4, 5],
// return true.
//
// Given [5, 4, 3, 2, 1],
// return false.

public class Solution {
    public boolean increasingTriplet(int[] nums) {
      int len = nums.length;
      if (len <= 2) return false;
      int p1 = nums[0];
      int p2 = p1;
      for (int i = 1; i < nums.length; i++){
        if (p1 == p2){
          if(nums[i] > p1){
            p2 = nums[i];
          }
          else {
            p1 = nums[i];
            p2 = nums[i];
          }
        }
        else {
          if (nums[i] > p2) return true;
          else if (nums[i] < p2 && nums[i] > p1){
            p2 = nums[i];
          }
          else if (nums[i] < p1){
            p1 = nums[i];
          }
        }
      }
      return false;
    }
}
