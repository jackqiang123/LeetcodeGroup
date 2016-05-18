// Find all possible combinations of k numbers that add up to a number n,
// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Ensure that numbers within the set are sorted in ascending order.
//
// Example 1:
//
// Input: k = 3, n = 7
//
// Output:
//
// [[1,2,4]]
//
//
// Example 2:
//
// Input: k = 3, n = 9
//
// Output:
//
// [[1,2,6], [1,3,5], [2,3,4]]
//
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
      res = new ArrayList<List<Integer>>();
      dfs(k, n, new ArrayList<Integer>(), 1);
      return res;
    }
    private void dfs(int k, int n, List<Integer> cur, int start){
      if (cur.size() == k){
        if (n == 0)
          res.add(new ArrayList<Integer>(cur));
      }
      else if (start >= 10 || n < 0) return;
      else{
        for (int i = start; i <= 9; i++){
          cur.add(i);
          dfs(k, n - i, cur, i+1);
          cur.remove(cur.size() - 1);
        }
      }

    }
}
