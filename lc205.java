// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while
// preserving the order of characters. No two characters may map to the
// same character but a character may map to itself.
//
// For example,
// Given "egg", "add", return true.
//
// Given "foo", "bar", return false.
//
// Given "paper", "title", return true.
//
// Note:
// You may assume both s and t have the same length.
//
public class Solution {
    public boolean isIsomorphic(String s, String t) {
      int slen = s.length();
      Map<Character, Character> map = new HashMap();
      for (int i = 0; i < slen; i++){
        char sc = s.charAt(i);
        char tc = t.charAt(i);
        if (map.get(sc) != null)
        {
          if (map.get(sc) != tc)
            return false;
        }
        else
        {
          if (!map.containsValue(tc))
            map.put(sc, tc);
          else return false;
        }
      }
      return true;
    }
}
