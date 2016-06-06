// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// For example,
// If n = 4 and k = 2, a solution is:
//
// [
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
// ]
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
      res = new ArrayList<List<Integer>>();
      dfs(n, k, 1, new ArrayList<Integer>());
      return res;
    }
    private void dfs(int n, int k, int start, ArrayList<Integer> cur){
      if (k == 0){
        res.add(new ArrayList<Integer>(cur));
      }
      else if (start + k - 1 > n){
        return;
      }
      else{
        for (int i = start; i <= n; i++){
            cur.add(i);
            dfs(n, k - 1, i + 1, cur);//starting from the next position
            cur.remove(cur.size()-1);

        }
      }

    }
}
