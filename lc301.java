// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
// Note: The input string may contain letters other than the parentheses ( and ).
//
// Examples:
//
// "()())()" -> ["()()()", "(())()"]
// "(a)())()" -> ["(a)()()", "(a())()"]
// ")(" -> [""]

// remark : StringBuilder is an object. equals() will be object equal
public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    Set<String> set = new HashSet();
    List<String> res = new ArrayList<String>();
    Queue<StringBuilder> queue = new LinkedList();
    queue.add(new StringBuilder(s));
    while(!queue.isEmpty()){
      StringBuilder cur = queue.remove();
      if (res.size() != 0 && res.get(0).length() > cur.length()) break;
      if (isValid(cur)){
        res.add(cur.toString());
      }
      else {
        List<StringBuilder> nb = findnb(cur);
        for (StringBuilder sb : nb){
          if (!set.contains(sb.toString()))
          {
             queue.add(sb);
             set.add(sb.toString());
          }
        }
      }
    }
    return res;
  }

  private boolean isValid(StringBuilder sb){
    Stack<Character> stack = new Stack();
    for (int i = 0; i < sb.length(); i++){
      if (sb.charAt(i) == '('){
        stack.push('(');
      }
      else if (sb.charAt(i) == ')'){
        if (stack.isEmpty()) return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  private List<StringBuilder> findnb(StringBuilder cur){
    List<StringBuilder> res = new ArrayList();
    for (int i = 0; i < cur.length(); i++){
      if (cur.charAt(i) == '(' || cur.charAt(i) == ')'){
        StringBuilder temp = new StringBuilder(cur);
        temp.deleteCharAt(i);
        res.add(temp);
      }
    }
    return res;
  }
}
