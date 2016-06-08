// Given an array of numbers nums, in which exactly two elements appear only once
//  and all the other elements appear exactly twice. Find the two elements that appear only once.
//
// For example:
//
// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it
//  using only constant space complexity?
public class Solution {
    public int[] singleNumber(int[] nums) {
      int bit = 0;
      for (int n : nums)
        bit ^= n;
      int count = 0;
      while((((bit >> count)) & 1) == 0){
        count++;
      }
      int xor = (1 << count);
      int left = 0;
      int right = 0;
      for (int i : nums){
        if ((xor & i) == 0){
          left ^= i;
        }
        else right ^= i;
      }
      int []res = new int[2];
      res[0] = left; res[1] = right;
      return res;
    }
}
