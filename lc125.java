// Given a string, determine if it is a palindrome,
// considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
    public boolean isPalindrome(String s) {
      int len = s.length();
      int i = 0;
      int j = len - 1;
      s = s.toUpperCase();
      while(i < j){
        if (s.charAt(i) == s.charAt(j)){
          i++; j--;
        }
        else if (!(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))))
          i++;
        else if (!(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j))))
          j--;
        else return false;
      }
      return true;
    }
}
