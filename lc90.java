// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
// Note:
//
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,2], a solution is:
//
// [
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
// ]
public class Solution {
      boolean []visit;
      List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visit = new boolean[nums.length];
      Arrays.sort(nums);
      res = new ArrayList<List<Integer>>();
      dfs(new ArrayList<Integer>(), 0, nums);
      return res;
    }
    private void dfs(ArrayList<Integer> cur, int start, int []nums){
      if (start == nums.length){
        res.add(new ArrayList<Integer>(cur));
      }
      else{
        dfs(cur, start + 1, nums);
        if (start == 0 || nums[start] != nums[start - 1] || visit[start - 1]){
          cur.add(nums[start]);
          visit[start] = true;
          dfs(cur, start + 1, nums);
          cur.remove(cur.size()-1);
          visit[start] = false;
        }
      }
    }
}
