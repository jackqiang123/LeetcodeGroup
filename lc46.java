// Given a collection of distinct numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {
    List<List<Integer>> res;
    boolean []visit;
    public List<List<Integer>> permute(int[] nums) {
      res = new ArrayList<List<Integer>>();
      visit = new boolean[nums.length];
      backtrack(nums, new ArrayList<Integer>());
      return res;
    }

    private void backtrack(int []nums, List<Integer> cur){
      if (cur.size() == nums.length){
        res.add(new ArrayList<Integer>(cur));
      }
      else{
        for(int i = 0; i < visit.length; i++){
          if (!visit[i]){
            visit[i] = true;
            cur.add(nums[i]);
            backtrack(nums, cur);
            cur.remove(cur.size()-1);
            visit[i] = false;
          }
        }
      }
    }
}
