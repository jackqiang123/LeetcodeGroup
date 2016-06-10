// Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that
// they add up to the target, where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are not zero-based.
//
// You may assume that each input would have exactly one solution.
public class Solution{
  public int[] twoSum(int []nums, int target){
    int lo = 0;
    int hi = nums.length;
    while(lo < hi){
      if (nums[lo] + nums[hi] == target){ // you may conisder overflow issue here
        int []res = {lo+1, hi+1};//one based index
        return res;
      }
      else if (nums[lo]+nums[hi] < target)
        lo++;
      else hi--;
    }
    return null;
  }
}
