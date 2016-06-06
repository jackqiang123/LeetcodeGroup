// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Note:
//
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//
// For example, given candidate set 10,1,2,7,6,1,5 and target 8,
// A solution set is:
// [1, 7]
// [1, 2, 5]
// [2, 6]
// [1, 1, 6]

public class Solution {
  List<List<Integer>> res;
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    res = new ArrayList<List<Integer>>();
    help(0, candidates, new ArrayList<Integer>(), target);
    return res;
  }
  private void help(int start, int []nums, ArrayList<Integer> cur, int target){
    if (target == 0){
      res.add(new ArrayList<Integer>(cur));
    }
    else if (target < 0 || start >= nums.length) return;
    else{
        for (int i = start; i < nums.length; i = increase(nums,i)){
          cur.add(nums[i]);
          help(i + 1, nums, cur, target - nums[i]);
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
