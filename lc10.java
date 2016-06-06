// Implement regular expression matching with support for '.' and '*'.
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true


public class Solution {
    public boolean isMatch(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        if (slen == 0) {
          if (plen == 0) return true;
          if (plen == 1) return false;
          else return p.charAt(1) == '*' && isMatch(s, p.substring(2));
        }
        if (plen == 0) return false;
        if (plen == 1) return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
        if (p.charAt(1) != '*'){
          return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
        }
        else {
              if ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p))
                return true;
        }
        return isMatch(s,p.substring(2)); // delete this char case
    }
}
