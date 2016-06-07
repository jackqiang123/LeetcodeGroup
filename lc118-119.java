// Given numRows, generate the first numRows of Pascal's triangle.
//
// For example, given numRows = 5,
// Return
//
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
//
// Subscribe to see which companies asked this question
// Given an index k, return the kth row of the Pascal's triangle.
//
// For example, given k = 3,
// Return [1,3,3,1].
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
public class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (numRows == 0) return res;
      List<Integer> cur = new ArrayList<Integer>();
      cur.add(1);
      res.add(cur);
      for (int i = 2; i <= numRows; i++){
          List<Integer> list = new ArrayList<Integer>();
          for (int j = 0; j < i; j++){
            if (j == 0 || j == i - 1) list.add(1);
            else list.add(res.get(res.size()-1).get(j - 1) + res.get(res.size()-1).get(j));
          }
          res.add(list);
      }
      return res;
    }
}
