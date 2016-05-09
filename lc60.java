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
      int []perm = new int[n+1];
      for (int i = 0; i < n; i++){
        if (i == 0 || i == 1) perm[0] = 1;
        else perm[i] = perm[i-1]*i;
      }
      boolean [] used = new boolean[10];
      StringBuilder res = new StringBuilder();
      for (int i = n; i >= 1; i--){
        int numofPerm = used[i - 1];
        res.append(findNextNumber(used));
      }
      return res.toString();
    }

    private int findNextNumber(){
      
    }
}
