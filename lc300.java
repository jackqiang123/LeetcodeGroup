// Given an unsorted array of integers, find the length of longest increasing subsequence.
//
// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
// Note that there may be more than one LIS combination, it is only necessary for you to return the length.
//
// Your algorithm should run in O(n2) complexity.
//
// Follow up: Could you improve it to O(n log n) time complexity?
public class Solution {
    public int lengthOfLIS(int[] nums) {
      //dp can lead to a O(n^2) algorithm
      int len = nums.length;
      if (len == 0) return 0;
      int []dp = new int[len];
      int max = 1;
      for (int i = 0; i < len; i++){
        if(i == 0){
          dp[i] = 1;
        }
        else {
          dp[i] = 1;
          for (int j = i - 1; j >= 0; j--){
            if (nums[j] < nums[i]){
              dp[i] = Math.max(dp[i], dp[j] + 1);
              max = Math.max(max, dp[i]);
            }
          }
        }
      }
      return max;
    }


    public int lengthOfLISNlogN(int[] nums) {
      int []dp = new int[nums.length];
      // dp is storing the smallest number to have consectuive seq length i +1
      int len = 0;
      for (int x : nums){
        int i = Arrays.binarySearch(dp, 0, len, x);
        if (i < 0) i = -(i+1);
        dp[i] = x; // note that x is the largest index elements, we can either replace previous existing x, or insert x into it
                    //x is the just larger than dp[i]
        if (i == len) len++; // if i is larger than all elemetns, then increase the range
        // since the inserting proccess is by binary search, then dp is sorted.
      }
      return len;
    }
}
