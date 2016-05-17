// Given an array of integers, every element appears three times except for one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
public class Solution {
    public int singleNumber(int[] nums) {
      int [] count = new int[32];
      for (int n : nums){
          int i = 0;
          while(n != 0){
            count[i] += (n & 1);
            count[i] %= 3;
            n = (n >> 1);
          }
      }
      int res = 0;
      for (int i = 0; i < 32; i++)
        res += (nums[i] * (1 << (31 - i)));
      return res;
    }
}
