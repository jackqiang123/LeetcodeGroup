// Given an array of size n, find the majority element. The majority element is
// the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.
//
public class Solution {
    public int majorityElement(int[] nums) {
      int c = nums[0];
      int count = 0;
      for (int i = 0; i < nums.length; i++){
        if (count == 0)
        {
          c = nums[i]; count++;
        }
        else if (c == nums[i]) count++;
        else
          count--;
      }
      return c;
    }
}
