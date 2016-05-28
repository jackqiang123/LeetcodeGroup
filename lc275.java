// Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
//
// Hint:
//
//    Expected runtime complexity is in O(log n) and the input is sorted.
// //
public class Solution {
    public int hIndex(int[] c) {
      int len = c.length;
      int lo = 0;
      int hi = c.length;
      while(lo < hi){
        int mid = (lo+hi)/2;
        if (isRight(mid, c)) lo = mid + 1;
        else hi = mid;
      }
      return isRight(lo, c) ? lo : lo - 1;
    }
    private boolean isRight(int h, int []c){
      if (h == 0) return true;
      return c[c.length-h] >= h;
    }
}
