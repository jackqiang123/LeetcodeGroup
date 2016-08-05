// Given a collection of distinct numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

public class Solution {
    List<List<Integer>> res;
    boolean []visit;
    public List<List<Integer>> permute(int[] nums) {
      res = new ArrayList<>();
      visit = new boolean[nums.length];
      dfs(nums, new ArrayList<Integer>());
      return res;
    }
    private void dfs(int []nums, List<Integer> cur){
      if (cur.size() == nums.length) {res.add(new ArrayList<Integer>(cur);}
      else {
        for (int i = 0; i < nums.length; i++){
          if (!visit[i]){
            visit[i] = true;
            cur.add(nums[i]);
            dfs(nums, cur);
            visit[i] = false;
            cur.remove(cur.size()-1);
          }
        }
      }
    }
}
