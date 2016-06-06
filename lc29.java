// Divide two integers without using multiplication, division and mod operator.
//
// If it is overflow, return MAX_INT.
public class Solution {
    public int divide(int d1, int d2) {
    boolean isNeg = (d1 < 0 && d2 > 0) || (d1 > 0 && d2 < 0);
    if (d1 == 0) return 0;
    if (d2 == 0) return Integer.MAX_VALUE;
    if (d2 == 1) return d1;
    long dividend = Math.abs((long)d1);
    long divisor = Math.abs((long)d2);
    long div = divisor;
    if (dividend < divisor) return 0;
    int bit = 0;
    while(dividend >= div){
      div <<= 1;
      bit++;
    }
    if (bit == 32 && !isNeg) return Integer.MAX_VALUE;
    long res = 0;
    while(bit >= 0){
      if (dividend >= (divisor<<bit)){
        dividend -= (divisor<<bit);
        res += (1<<bit);
      }
      bit--;
    }
    res = isNeg ? -res : res;
    if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
      res = Integer.MAX_VALUE;
    return (int)res;
  }
}
