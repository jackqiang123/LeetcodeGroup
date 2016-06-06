// Given a set of *distinct* integers, nums, return all possible subsets.
//
// Note:
//
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,3], a solution is:
//
// [
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
// ]
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
      res = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      dfs(new ArrayList<Integer>(), 0, nums);
      return res;
    }
    private void dfs(List<Integer> cur, int start, int nums[]){
      if (start == nums.length){
        res.add(new ArrayList<Integer>(cur));
      }
      else {// in face of current element, we choose add it or not
        dfs(cur, start + 1, nums);
        cur.add(nums[start]);
        dfs(cur, start + 1, nums);
        cur.remove(cur.size()-1);
      }

    }
}
