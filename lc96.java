// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
// For example,
// Given n = 3, there are a total of 5 unique BST's.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
public class Solution {
    public int numTrees(int n) {
      if (n == 0 || n == 1) return 1;
      int res = 0;
      int []dp = new int[n+1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i <= n; i++){
        // more efficient alg is to do dynamic programming
        // or use a cache array
        for (int mid = 1; mid <= i; mid++)
            dp[i] += dp[mid - 1] * dp[i - mid];
      }
      return dp[n];
    }
}
