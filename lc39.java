// Given a set of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
//
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//
// For example, given candidate set 2,3,6,7 and target 7,
// A solution set is:
// [7]
// [2, 2, 3]
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      Arrays.sort(candidates);
      res = new ArrayList<List<Integer>>();
      help(0, candidates, new ArrayList<Integer>(), target);
      return res;
    }
    private void help(int start, int []nums, ArrayList<Integer> cur, int target){

      if (target == 0){
        res.add(new ArrayList<Integer>(cur));
      }
      else if (target <= 0) return;
      else{
          for (int i = start; i < nums.length; i = increase(nums,i)){
            cur.add(nums[i]);
            help(i, nums, cur, target - nums[i]);
            cur.remove(cur.size()-1);
          }
      }
    }

    private int increase(int []nums, int i){
      int target = nums[i];
      while(i < nums.length && nums[i] == target) i++;
      return i;
    }
}
