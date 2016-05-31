// Given a string which contains only lowercase letters, remove duplicate letters
// so that every letter appear once and only once. You must make sure your result is the
// smallest in lexicographical order among all possible results.
//
// Example:
//
// Given "bcabc"
// Return "abc"
//
// Given "cbacdcbc"
// Return "acdb"
public class Solution {
    public String removeDuplicateLetters(String s) {
      int[]count = new int[26];
      for (int i = 0; i < s.length(); i++){
        count[s.charAt(i)-'a']++;
      }
      boolean[]visit = new boolean[26];
      Stack<Character> stack = new Stack();
      for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        count[c-'a']--;
        if (visit[c-'a']) continue;
        while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0)
           visit[stack.pop() - 'a'] = false;
        stack.push(c);
        visit[c-'a'] = true;
      }
        StringBuilder res = new StringBuilder();
        while(stack.isEmpty() == false)
          res.insert(0, stack.pop());
        return res.toString();
    }
}
