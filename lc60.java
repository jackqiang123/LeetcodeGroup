// The set [1,2,3,…,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//
//     "123"
//     "132"
//     "213"
//     "231"
//     "312"
//     "321"
//
// Given n and k, return the kth permutation sequence.
//
// Note: Given n will be between 1 and 9 inclusive.
public class Solution {
    public String getPermutation(int n, int k) {
      k--;
      if (n == 1) return "1";
      int []perm = new int[n+1];
      for (int i = 0; i <= n; i++){
        if (i == 0 || i == 1) perm[i] = 1;
        else perm[i] = perm[i-1]*i;
      }
      boolean [] used = new boolean[n+1];
      StringBuilder res = new StringBuilder();
      for (int i = n; i >= 1; i--){
        int numofPerm = perm[i - 1];
        res.append(findNextNumber(used, k/numofPerm));
        k = k%numofPerm;
      }
      return res.toString();
    }

    private int findNextNumber(boolean[]visit, int rank){
      int count = 0;
      for (int i = 1; i < visit.length; i++){
        if (visit[i]) continue;
        if (rank == count) {
          visit[i] = true;
          return i;
        }
        else count++;
      }
      return -1;
    }
}
