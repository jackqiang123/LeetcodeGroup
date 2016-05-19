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
        if (Character.isDigit(c))
          res = res * 10 + (c-'0');
        else if (c == '+' || c == '-'){
            res *= sign;
            if (c == '+') sign = 1;
            else sign = -1;
        }
        else if (c == '('){

        }
        else if (c == ')'){

        }
        i++;
      }
      return res;
    }
}
