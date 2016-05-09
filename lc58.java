// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space characters only.
//
// For example,
// Given s = "Hello World",
// return 5.
public class Solution {
    public int lengthOfLastWord(String s) {
      int len = s.length();
      if(len == 0) return 0;
      int index = len - 1;
      while(index >= 0){
        if (s.charAt(index) == ' ')
          index--;
        else break;
      }
      if (index == -1) return 0;
      int res = 0;
      while(index >= 0){
        if (s.charAt(index) != ' ')
        {index--; res++;}
        else break;
      }
      return res;
    }
}
