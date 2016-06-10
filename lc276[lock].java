
    // There is a fence with n posts, each post can be painted with one of the k colors.
    //
    // You have to paint all the posts such that no more than two adjacent fence posts have the same color.
    //
    // Return the total number of ways you can paint the fence.
    //
    // Note: n and k are non-negative integers.

    public class Solution {
        public int numWays(int n, int k) {
          if (n == 1) return k;
          if (n == 2) return k*k;
          return numWays(n - 1, k) * (k-1) + numWays(n - 2, k)*(k-1);
        }
      }
