// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O(n) complexity.
public class Solution {
    public int longestConsecutive(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i : nums){
        map.put(i, 1);
      }
      int res = 1;
      Set<Integer> num = map.keySet(); // no duplicate num exist
      for (int n : num){
        map.put(n, 1 + (map.get(n-1) == null ? 0 : map.get(n-1)) + (map.get(n+1) == null ? 0 : map.get(n+1)));
        if (map.get(n-1) != null) map.put(n - map.get(n-1), map.get(n));
        if (map.get(n+1) != null) map.put(n + map.get(n+1), map.get(n));
        res = Math.max(res, map.get(n));
      }
      return res;
    }
}
