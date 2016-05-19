// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
// non-negative integers and empty spaces .
//
// You may assume that the given expression is always valid.
//
// Some examples:
//
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
public class Solution {
    public int calculate(String s) {
      int res = 0;
      int sign = 1;
      Stack<Integer> stack = new Stack();
      int i = 0;
      while(i < s.length()){
        char c = s.charAt(i);
        if (Character.isDigit(c)){
            int num = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i)))
              num = num * 10 + (s.charAt(i++) - '0');
            res += sign*num;
            continue;
        }
        else if (c == '+')
          sign = 1;
        else if (c == '-')
          sign = -1;
        else if (c == '(')
        {
          stack.push(res);
          stack.push(sign);
          res = 0; sign = 1;
        }
        else if (c == ')'){
          res = stack.pop() * res + stack.pop();
          sign = 1;
        }
        i++;
      }
      return res;
    }
}
