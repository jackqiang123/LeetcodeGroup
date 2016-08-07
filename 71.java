// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
      path = path.trim();
      String paths[] = path.split("/");
      Stack<String> stack = new Stack<>();
      for (String s : paths){
        if (s.equals(".")) continue;
        else if (s.equals("..")){
          if (!stack.isEmpty()) stack.pop();
        }
        else if (s.length() != 0){
          stack.push(s);
        }
      }
      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty()){
        sb.insert(0, stack.pop());
        sb.insert(0, '/');
      }
      if (sb.length() == 0) return "/";
      return sb.toString();
    }
}
