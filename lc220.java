// Given an array of integers, find out whether there are two distinct indices i
// and j in the array such that the difference between nums[i] and nums[j] is at
// most t and the difference between i and j is at most k.
//
// since we are going over the elements from left to right, we shall consider put value as the key, since we already has a good order of index.
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      if (k < 1 || t < 0) return false;
      TreeMap<Integer, Integer> map = new TreeMap();
      for (int i = 0; i < nums.length; i++){
        if (i - k - 1 >= 0 && map.get(nums[i-k-1]) != null && map.get(nums[i-k-1]) == i-k-1)
          map.remove(nums[i-k-1]);
        int valueLower = nums[i] < Integer.MIN_VALUE + t ? Integer.MIN_VALUE : nums[i] - t;
        Integer minValue = map.ceilingKey(valueLower);
        int valueUpper = nums[i] > Integer.MAX_VALUE - t ? Integer.MAX_VALUE : nums[i] + t;
        Integer maxValue = map.floorKey(valueUpper);
        if (minValue != null && maxValue != null && minValue <= maxValue)
          return true;
        map.put(nums[i], i);
      }
      return false;
    }
}
