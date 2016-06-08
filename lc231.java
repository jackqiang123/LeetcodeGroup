// Given an integer, write a function to determine if it is a power of two.
public class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      while(n != 1){
        if ((n & 1) != 0) return false;
        else n >>= 1;
      }
      return true;
    }
}
