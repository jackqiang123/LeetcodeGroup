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
    public List<Integer> findSubstring(String s, String[] words) {
      int size = words[0].length();
      List<Integer> res = new ArrayList<Integer>();
      Set<String> dict = new HashSet();
      for (String ss : words)
        dict.add(ss);
      for (int i = 0; i < size; i++){
        helper(res, s, i, dict,size);
      }
      return res;
    }
    private void helper(List<Integer> res, String s, int start, Set<String> dict, int size){
      HashMap<String,Integer> map = new HashMap<String,Integer>();
      int wordCount = 0;
      int index = start;
      for (int i = start; i < s.length(); i+=size){
        String cur = s.subString(i,i+size);
        if (dict.contains(cur)){
          if (map.get(cur) == null || map.get(cur) < index)){
            map.put(cur,i);
            wordCount++;
            if (wordCount == dict.size()) {
              res.add(index);
              index = i + size;
              wordCount = 0;
            }
          }
          else if (map.get(cur) >= start){
            index = map.get(cur) + size;
            wordCount -= (map.get(cur) - index)/size;
            map.put(cur,i);
          }
        }else {
          index = i + size; wordCount = 0;
        }
      }
    }
}
