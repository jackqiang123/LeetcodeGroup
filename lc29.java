// Divide two integers without using multiplication, division and mod operator.
//
// If it is overflow, return MAX_INT.
public class Solution {
    public int divide(int dividend, int divisor) {
      boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
      if (dividend == 0) return 0;
      if (divisor == 0) return Integer.MAX_VALUE;
      int res = 0;
      while(dividend >= divisor){
        dividend -= divisor;
        res++;
      }
      return isNege ? -res:res;
    }
}
