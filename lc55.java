// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false.
public class Solution {
    public boolean canJump(int[] nums) {
      int len = nums.length;
      if (len <= 1) return true;
      int curFar = 0;
      int potFar = nums[0];
      for (int i = 0; i < nums.length; i++){
        potFar = Math.max(potFar, nums[i] + i);
        if (curFar <= i){
          if (potFar <= i) return false;
          curFar = potFar;
        }
        if (potFar >= len - 1) return true;
      }
      return true;
    }
}
