// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
// You may assume that the given expression is always valid.
//
// Some examples:
//
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
//
// Note: Do not use the eval built-in library function.
public class Solution {
    public int calculate(String s) {
      int i = 0;
      Stack<Integer> stack = new Stack();
      int res = 0;
      int cur = 0;
      char sign = '+';
      while(i < s.length()){
        char c = s.charAt(i);
        if (Character.isDigit(c)){
          while(i < s.length() && Character.isDigit(s.charAt(i))){
            cur = cur * 10 + s.charAt(i++) - '0';
          }
          if (sign == '+')
            stack.push(cur);
          else if (sign == '-')
            stack.push(-cur);
          else if (sign == '*')
            stack.push(stack.pop()*cur);
          else if (sign == '/')
            stack.push(stack.pop()/cur);
          cur = 0;
          if (i == s.length()) break;
        }
        c = s.charAt(i);
        if (c == '+' || c == '-' || c == '*' || c == '/')
          sign = c;
        i++;
      }
      res = 0;
      while(stack.isEmpty() == false)
        res += stack.pop();
      return res;
    }
}
