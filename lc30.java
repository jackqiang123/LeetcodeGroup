// You are given a string, s, and a list of words, words, that are all of the same length.
// Find all starting indices of substring(s) in s that is a concatenation of each word in
// words exactly once and without any intervening characters.
//
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
//
// You should return the indices: [0,9].
// (order does not matter).

public class Solution {
    private int targetLen;
    public List<Integer> findSubstring(String s, String[] words) {
      int size = words[0].length();
      targetLen = 0;
      List<Integer> res = new ArrayList<Integer>();
      Map<String, Integer> dict = new HashMap();
      for (String ss : words)
      {
          if(dict.get(ss) == null) dict.put(ss,0);
          dict.put(ss, dict.get(ss)+1);
          targetLen++;
      }
      for (int i = 0; i < size; i++){
        helper(res, s, i, dict, size);
      }
      return res;
    }
    private void helper(List<Integer> res, String s, int start, Map<String,Integer> dict, int size){
      HashMap<String,Integer> map = new HashMap<String,Integer>();
      int wordCount = 0;
      int index = start;
      int len = 0;
      for (int i = start; i + size <= s.length(); i+=size){
        String cur = s.substring(i, i + size);
        if (dict.get(cur) == null){
            len = 0;
            index = i + size;
            map = new HashMap();
            continue;
        }
        while(map.get(cur) == dict.get(cur)){
            len--;
            map.put(s.substring(index, index + size), map.get(s.substring(index, index + size))-1);
            index+=size;
        }
        map.put(cur, map.get(cur) == null ? 1 : map.get(cur) + 1);
        len++;
        if (len == targetLen){
            res.add(index);
            map.put(s.substring(index, index + size), map.get(s.substring(index, index + size))-1);
            index += size;
            len--;
        }
      }
    }
}
