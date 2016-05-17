// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<Integer>();
      for (String s : tokens){
        if ("+".equals(s) || "*".equals(s) || "-".equals(s) || "/".equals(s))
        {
          int y = stack.pop();
          int x = stack.pop();
          if ("+".equals(s)) stack.push(x+y);
          else if ("*".equals(s)) stack.push(x*y);
          else if ("-".equals(s)) stack.push(x-y);
          else stack.push(x/y);
        }
        else stack.push(Integer.parseInt(s));
      }
      return stack.pop();
    }
}
