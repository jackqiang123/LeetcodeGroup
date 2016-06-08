// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
// Example:
// Given num = 16, return true. Given num = 5, return false.
//
// Follow up: Could you solve it without loops/recursion?
public class Solution {
    public boolean isPowerOfFour(int num) {
      if (num == 0) return false;
      return num == 1 || (num%4 == 0 && isPowerOfFour(num/4));
    }
    // without loop will use the information that upper bound of power of 4 can be precomputed
    // however, we can not directly use MAX_4_POWER % 4 == 0.
    // we will need to check more things
}
