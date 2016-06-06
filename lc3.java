// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3.
// Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int res = 1;
        int []lasttime = new int[256];
        for (int i = 0; i < lasttime.length; i++)
          lasttime[i] = -1;
        int i = 0; int j = 0;
        while(j < s.length())
        {
          if (lasttime[s.charAt(j)] < i){
            res = Math.max(res, j - i + 1);
            lasttime[s.charAt(j)] = j;
            j++;
          }
          else{
            i = lasttime[s.charAt(j)] + 1;
            lasttime[s.charAt(j)] = j;
            j++;
          }
        }
        return res;
    }
}
