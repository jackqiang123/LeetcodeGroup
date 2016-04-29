// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution{
  public boolean isValid(String s) {
      int len = s.length();
      if (len == 0) return true;
      Stack<Character> stack = new Stack();
      for (int i = 0; i < len; i++){
        char c = s.charAt(i);
        if (c == '(' || c == '{' || c == '[')
          stack.push(c);
        else{
          if (stack.isEmpty()) return false;
          char top = stack.peek();
          if (c==')' && top != '(')
             return false;
          if (c==']' && top != '[')
                return false;
          if (c=='}' && top != '{')
                return false;
          stack.pop();
        }
      }
      return stack.isEmpty();
  }
}
