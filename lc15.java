// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
//     Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//     The solution set must not contain duplicate triplets.
//
//     For example, given array S = {-1 0 1 2 -1 -4},
//
//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) return res;
        for (int i = 0; i < len - 2; i = increase(nums,i)){
          int lo = i + 1;
          int hi = len - 1;
          int a = nums[i];
          while(lo < hi){
            int b = nums[lo];
            int c = nums[hi];
            if (a + b + c < 0) lo++;
            else if (a + b + c > 0) hi--;
            else {
              ArrayList<Integer> list = new ArrayList<Integer>();
              list.add(a); list.add(b); list.add(c); res.add(list);
              lo = increase(nums, lo);
            }
          }
        }
        return res;
    }

    private int increase(int[] nums, int i){
      int target = nums[i];
      while(i < nums.length && nums[i] == target)
        i++;
      return i;
    }
}
