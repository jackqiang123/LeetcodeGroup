// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//
// The input string does not contain leading or trailing spaces and the words are always separated by a single space.
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
// Could you do it in-place without allocating extra space?
public class Solution {
    public void reverseWords(char[] s) {
      reverse(s, 0, s.length); // include head, exclude tail
      int i = 0; int j = 0;
      while(j < s.length){
        while(j < s.length && s[j] != ' ')  j++;
        reverse(s, i, j);
        j++; i = j;
      }
    }
    private void reverse(char[]array, int start, int end){
      end--;
      while(start < end){
        swap(array, start++, end--);
      }
    }
    private void swap(char[]array, int i, int j){
      char c = arrar[i]; array[i] = array[j]; array[j] = c;
    }
}
