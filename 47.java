// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
      Arrays.sort(nums);
      res = new ArrayList<>();
      if (nums.length == 0) return res;
      helper(nums, new boolean[nums.length], new ArrayList<Integer>());
      return res;
    }
    private void helper(int []nums, boolean visit[], List<Integer> cur){
      if (cur.size() == nums.length){
        res.add(new ArrayList<Integer>(cur));
      }
      else {
        for (int i = 0; i < nums.length; i++){
          if (visit[i]) continue;
          if (i != 0 && nums[i] == nums[i-1] && !visit[i-1]) continue;
          visit[i] = true;
          cur.add(nums[i]);
          helper(nums, visit, cur);
          visit[i] = false;
          cur.remove(cur.size() - 1);
        }
      }
    }
}
