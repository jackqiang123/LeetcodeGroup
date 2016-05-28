// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Examples:

//
//     pattern = "abba", str = "dog cat cat dog" should return true.
//     pattern = "abba", str = "dog cat cat fish" should return false.
//     pattern = "aaaa", str = "dog cat cat dog" should return false.
//     pattern = "abba", str = "dog dog dog dog" should return false.
//

// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class Solution {
    public boolean wordPattern(String pattern, String str) {

      HashMap<Character, String> map1 = new HashMap();
      HashMap<String, Character> map2 = new HashMap();
      String[]strs = str.split(" ");
      if (pattern.length() != strs.length) return false;
      for (int i = 0; i < pattern.length(); i++){
        char key = pattern.charAt(i);
        String value = strs[i];
        if (map1.containsKey(key)){
          if (!map1.get(key).equals(value)) return false;
          if (!map2.containsKey(value)) return false;
          if (map2.get(value) != key) return false;
        }
        else{
          if (map2.get(value) != null)  return false;
          map1.put(key, value);
          map2.put(value, key);
        }

      }
      return true;
    }
}
