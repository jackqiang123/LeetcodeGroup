// Implement pow(x, n).
public class Solution {
    public double myPow(double x, int n) {
      if (n == 0) return 1;
      if (n < 0) return myPow(1/x, -n);
      if (n%2 == 0) {
        double res = myPow(x, n/2);
        return res*res;
      }
      else {
        double res = myPow(x,n/2);
        return res*res*x;
      }
    }
}
