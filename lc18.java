// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
//
//     Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//     The solution set must not contain duplicate quadruplets.
//
//     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//     A solution set is:
//     (-1,  0, 0, 1)
//     (-2, -1, 1, 2)
//     (-2,  0, 0, 2)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      int len = nums.length;
      for (int i = 0; i < len - 3; i = increase(nums, i)){
        for (int j = i + 1; j < len - 2; j = increase(nums,j)){
          int lo = j + 1;
          int hi = len - 1;
          while(lo < hi){
            int a = nums[i];
            int b = nums[j];
            int c = nums[lo];
            int d = nums[hi];
            int sum = a + b + c + d;
            if (sum == target){
              ArrayList<Integer> cur = new ArrayList<Integer>();
              cur.add(a);cur.add(b);cur.add(c);cur.add(d); res.add(cur);
               lo = increase(nums, lo);
            }else if (sum < target){
              lo = increase(nums, lo);
            }
            else hi = decrease(nums,hi);
          }
        }
      }
      return res;
    }

    private int increase(int[]nums, int i){
      int target = nums[i];
      while(i < nums.length && nums[i] == target) i++;
      return i;
    }

    private int decrease(int[]nums, int i){
      int target = nums[i];
      while(i >= 0 && nums[i] == target) i--;
      return i;
    }
}
