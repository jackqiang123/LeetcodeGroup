// Implement int sqrt(int x).
//
// Compute and return the square root of x.
public class Solution {
    public int mySqrt(int x) {
      int lo = 1;
      int hi = x;
      while(lo < hi){
        int mid = lo + (hi-lo)/2;
        //[mid, mid + 1)
        if (x/mid >= mid && x/(mid+1) < mid + 1){
          return mid;
        }
        else if (x/mid < mid)
          hi = mid;
        else lo = mid + 1;
      }
      return (lo/mid >= mid && lo/(mid + 1)< mid + 1) ? lo : lo + 1;
    }
}
