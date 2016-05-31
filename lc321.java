// Given two arrays of length m and n with digits 0-9 representing two numbers.
// Create the maximum number of length k <= m + n from digits of the two.
// The relative order of the digits from the same array must be preserved.
// Return an array of the k digits. You should try to optimize your time and space complexity.
//
// Example 1:
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// return [9, 8, 6, 5, 3]
//
// Example 2:
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// return [6, 7, 6, 0, 4]
//
// Example 3:
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// return [9, 8, 9]
//

public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k){
    int len1 = nums1.length;
    int len2 = nums2.length;
    int res = new int[k];
    for (int i = Math.max(0, k-len2); i <= k && i <= len1; i++){
      int []candidate = merge(getNumber(nums1, nums1.length() - 1, i), getNumber(nums2, nums2.length() - 1, k - i));
      if (!greater(res, candidate)) res = candidate;
    }
    return res;
  }

  private int[]merge(int l, int r){
    String left = String.valueOf(l);
    String right = String.valueOf(r);
    int res[] = new int[left.length() + right.length()];
    int pos = 0;
    int i = 0; int j = 0;
    while(pos < res.length){
      if (i < left.length() && j < right.length()){
        if (left.charAt(i) > right.charAt(j))
          res[pos++] = left.charAt(i++) - '0';
        else res[pos++] = right.charAt(j++) - '0';
      }
      else if (i < left.length()){
        res[pos++] = left.charAt(i++) -'0';
      }
      else {
        res[pos++] = right.charAt(j++) - '0';
      }
    }
    return res;
  }

  private boolean greater(int []c1, int []c2){
      for (int i = 0; i < c1.length; i++){
        if (c1[i] > c2[i]) return true;
        else if (c1[i] < c2[i]) return false;
      }
      return false;
  }


  private int getNumber(int[]nums, int end, int k){
   int [][]dp = new int[end+1][k+1];
   for (int i = 0; i <= end; i++){
     for (int j = 0; j < dp[0].length; j++){
      if (j == 0) dp[i][j] = 0;
      else if (i == 0) dp[i][j] = nums[i];
      else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]*10+nums[i]);
     }
   }
   return dp[end][k];
  }

  public int[] maxNumberUsingDP(int[] nums1, int[] nums2, int K) {
       int len1 = nums1.length;
       int len2 = nums2.length;
       int [][][] dp = new int[len1 + 1][len2 + 1][K+1];
       for (int k = 0; k <= K; k++){
         for (int i = 0; i <= len1; i++){
           for (int j = 0; j <= len2; j++){
             if (k == 0 || (i == 0 && j == 0) || (i+j < k)) dp[i][j][k] = 0;
             else if (i == 0){
               dp[i][j][k] = getNumber(nums2, j - 1, k);
             }
             else if (j == 0){
               dp[i][j][k] = getNumber(nums1, i - 1, k);
             }
             else {
               dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
               int n1 = dp[i-1][j][k-1]*10 + nums1[i-1];
               int n2 = dp[i][j-1][k-1]*10 + nums2[j-1];
               dp[i][j][k] = Math.max(dp[i][j][k], Math.max(n1,n2));
             }
           }
         }
       }
       int num = dp[len1][len2][K];
       int len = String.valueOf(num).length();
       int res[] = new int[len];
       for (int i = len - 1; i >= 0; i--)
       {  res[i] = num%10; num /= 10;}
       return res;
     }
 }
