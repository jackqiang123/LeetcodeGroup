// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// For example:
// Given array A = [2,3,1,1,4]
//
// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

//using dp, we can achieve n^2. but using gready we get linear complexity
public class Solution {
    public int jump(int[] nums) {
      int jump = 0;
      int curFar = 0; //possible current position
      int potFar = nums[0];  // farthest next position
      if (nums.length == 1) return 0;
      for (int i = 0; i < nums.length; i++){
        if (curFar < i) {
          jump++;
          curFar = potFar;
        }
        if (curFar >= nums.length - 1) return jump;
        potFar = Math.max(potFar, i + nums[i]);
      }
      return -1;
    }
}
