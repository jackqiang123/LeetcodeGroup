// Given an unsorted array of integers, find the length of longest increasing subsequence.
//
// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
//
// Your algorithm should run in O(n2) complexity.
//
// Follow up: Could you improve it to O(n log n) time complexity?
public class Solution {
    // dp reaches n^2 complexity
    // binary search lead to nlogn
    public int lengthOfLIS(int[] nums) {
      if (nums.length <= 1) return nums.length;
      int []dp = new int[nums.length];
      int max = 0;
      for (int i = 0; i < nums.length; i++){
          dp[i] = 1;
          for (int j = i - 1; j >= 0; j--){
            if (nums[j] < nums[i])
              dp[i] = Math.max(dp[i], 1 + dp[j]);
          }
        max = Math.max(max, dp[i]);
      }
      return max;
    }

    public int lengthOfLIS(int[] nums) {
    if (nums.length <= 1) return nums.length;
    int []dp = new int[nums.length];
    int len = 0;
    for (int i : nums){
      int index = Arrays.binarySearch(dp, 0, len, i);
      if (index < 0) index = -(index+1);
      if (index >= len) len++;
      dp[index] = i;
    }
    return len;
  }
}
