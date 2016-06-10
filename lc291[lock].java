// Problem Description:
//
// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
//
// Examples:
//
//         pattern = "abab", str = "redblueredblue" should return true.
//         pattern = "aaaa", str = "asdasdasdasd" should return true.
//         pattern = "aabb", str = "xyzabcxzyabc" should return false.
//
// Notes:
// You may assume both pattern and str contains only lowercase letters.
public class Solution{
  Map<Character, String> cToString;
  Map<String, Character> stringToC;
  public boolean wordPatternMatch(String pattern, String str) {
    cToString = new HashMap();
    stringToC = new HashMap();
    return helper(pattern, str, 0, 0);
  }
  private boolean helper(String pattern, String str, int pindex, int sindex){
    if (pindex == pattern.length()){
      return true;
    }
    else{
      char c = pattern.charAt(pindex);
      if (cToString.get(c) != null){
        String value = cToString.get(c);
        if (stringToC.get(value) == null || stringToC.get(value) != c) return false;
        if (sindex + value.length() > str.length()) return false;
        if (str.substring(sindex, sindex + value.length()).equals(value) == false) return false;
        return helper(pattern, str, pindex + 1, sindex + value.length());
      }
      else {// try different mapping place
        for (int i = sindex + 1; i <= str.length(); i++){
          String value = str.substring(sindex, i);
          if (stringToC.get(value) != null) continue;// cannot use value
          cToString.put(c,value);
          stringToC.put(value,c);
          if (helper(pattern, str, pindex + 1, i)) return true;
          cToString.remove(c);
          stringToC.remove(value);
        }
        return false;
      }
    }
  }
}
