// Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
//  If there isn't one, return 0 instead.
//
// Example 1:
// Given nums = [1, -1, 5, -2, 3], k = 3,
// return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
//
// Example 2:
// Given nums = [-2, -1, 2, 1], k = 1,
// return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
//
// Follow Up:
// Can you do it in O(n) time?
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      int res = 0;
      HashMap<Integer, Integer> map = new HashMap();
      int curSum = 0;
      map.put(0, -1);
      for (int i = 0; i < nums.length; i++){
        curSum += nums[i];
        if (map.get(curSum - k) != null){
          res = Math.max(res, i - map.get(curSum - k));
        }
        if (map.get(curSum) == null)
          map.put(curSum, i);
      }
      return res;
    }
  }
