// Implement pow(x, n).
public class Solution {
    public double myPow(double x, int n) {
      if (n == 0) return 1.0;
      if (n == Integer.MIN_VALUE) return myPow(1/x, Integer.MAX_VALUE)*(1/x);
      if (n < 0) return myPow(1/x, -n);
      if (n%2 == 0) {
        return myPow(x*x, n/2);
      }
      else {
        return myPow(x*x, n/2)*x;
      }
    }
}
