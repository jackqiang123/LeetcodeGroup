// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < s.length(); i++){
        if (stack.isEmpty()) {stack.push(i);continue;}
        char cur = s.charAt(i);
        if (cur == ')' && s.charAt(stack.peek()) == '(') stack.pop();
        else stack.push(i);
      }
      if (stack.isEmpty()) return s.length();
      int last = stack.pop();
      int res = s.length() - 1 - last;
      while(!stack.isEmpty()){
        int cur = stack.pop();
        if (last - cur - 1 > res)
          res = last - cur - 1;
        last = cur;
      }
      return Math.max(res, last);
    }

}
