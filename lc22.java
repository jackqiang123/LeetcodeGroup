// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// For example, given n = 3, a solution set is:
//
// "((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        helper(new StringBuilder(), n, n);
        return res;
    }
    private void helper(StringBuilder cur, int left, int right){
      if (left == 0 && right == 0){
        res.add(cur.toString()); return;
      }
      if (left == right){
        cur.append('(');
        helper(cur,left - 1, right);
        cur.deleteCharAt(cur.length() - 1);
      }
      else if (left < right){
        if (left > 0){
        cur.append('(');
        helper(cur,left - 1, right);
        cur.deleteCharAt(cur.length() - 1);}
        if (right > 0){
        cur.append(')');
        helper(cur,left, right - 1);
        cur.deleteCharAt(cur.length() - 1);
       }
      }

    }
}
