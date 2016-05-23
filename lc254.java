// Numbers can be regarded as product of its factors. For example,
//
// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.
//
// Note:
//
// Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.
//
//
// Examples:
// input: 1
// output:
//
// []
// input: 37
// output:
//
// []
// input: 12
// output:
//
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
// input: 32
// output:
//
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]
public class Solution {
    public List<List<Integer>> getFactors(int n) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (n <= 2) return res;
      for (int i = 2; i < n; i++){
        if (n%i == 0){
          List<List<Integer>> curRes = helper(i, n/i);
          for (List<Integer> cur : curRes){
            cur.add(0, i);
            res.add(cur);
          }
        }
      }
      return res;
    }

    private List<List<Integer>> helper(int lowerBound, int number){
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (lowerBound > number) return res;
      List<Integer> self = new ArrayList<Integer>();
      self.add(number);
      res.add(self);
      for (int i = lowerBound; i < number; i++)
      {
        if (number%i == 0){
          List<List<Integer>> cur = helper(i, number/i);
          for (List<Integer> list : cur){
            list.add(0, i);
            res.add(list);
          }
        }
      }
      return res;
    }
  }
