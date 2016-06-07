// Given an array of integers, every element appears three times except for one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
public class Solution {
    public int singleNumber(int[] nums) {
      int [] count = new int[32];
      for (int n : nums){
        for (int i = 0; i < 32; i++){
            count[i] += ((n>>i) & 1);
        }
      }
      int res = 0;
      for (int i = 0; i < 32; i++)
        res += (count[i]%3) * (1 << i);
      return res;
    }
}
