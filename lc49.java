// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//     For the return value, each inner list's elements must follow the lexicographic order.
//     All inputs will be in lower-case.
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<String, List<String>>();
      for (String s : strs){
        String key = getKey(s);
        if (map.containsKey(key)){
          map.get(key).add(s);
        }
        else {
          List<String> list = new ArrayList<String>();
          list.add(s);
          map.put(key, list);
        }
      }
      List<List<String>> res = new ArrayList<List<String>>();
      for (String s : map.keySet()){
        Collections.sort(map.get(s));
        res.add(map.get(s));
      }
      return res;
    }

    private String getKey(String s){
      char [] array = s.toCharArray();
      Arrays.sort(array);
      return new String(array);
    }

}
