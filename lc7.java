// Reverse digits of an integer.
//
// Example1: x = 123, return 321
// Example2: x = -123, return -321
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

public class Solution {
    public int reverse(int x) {
      if (x == Integer.MIN_VALUE) return 0;
      boolean isPos = (x>=0);
      if (!isPos) x = -x;
      int res = 0;
      while( x != 0){
        int bit = x%10;
        if (res > (Integer.MAX_VALUE-bit)/10) return 0;
        res = res * 10 + bit;
        x = x/10;
      }
      return isPos ? res : -res;
    }
}
