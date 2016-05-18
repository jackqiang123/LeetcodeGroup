// Given an array of n positive integers and a positive integer s,
// find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.
//
// click to show more practice.
//
// More practice:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
public class Solution {
    // nlogn method will be get the accmulation, and do binary search on that array for each iterator.
    public int minSubArrayLen(int s, int[] nums) {
    // linear solution will be two pointer
    int i = 0; int j = 0; int len = nums.length;
    if (len == 0) return 0;
    int curSum = 0;
    int best = Integer.MAX_VALUE;
    while(j < len){
      curSum += nums[j];
      while(curSum >= s) {
        best = Math.min(best, j - i + 1);
        curSum -= nums[i];
        i++;
      }
      j++;
    }
    if (best == Integer.MAX_VALUE) return 0;
    return best;
    }
}
