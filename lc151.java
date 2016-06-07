// Given an input string, reverse the string word by word.
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.
//
// click to show clarification.
//
// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.
public class Solution {
    public String reverseWords(String s) {
      s = s.trim();
      String[]sSplit = s.split("\\s+");
      reverse(sSplit);
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < sSplit.length; i++)
      {
        res.append(sSplit[i]);
        if (i != sSplit.length - 1)
          res.append(" ");
      }
      return res.toString();
    }

    private void reverse(String[]sArray){
      int i = 0;
      int j = sArray.length - 1;
      while(i < j){
        swap(sArray, i++, j--);
      }
    }

    private void swap(String[]sArray, int i, int j){
        String t = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = t;
    }
}
