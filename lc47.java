// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].
public class Solution {
  List<List<Integer>> res;
  boolean []visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
      Arrays.sort(nums);
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
          if (visit[i]) continue;
            if (i == 0 || nums[i] != nums[i-1] || (!visit[i-1] && nums[i] == nums[i-1]))
              {
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
