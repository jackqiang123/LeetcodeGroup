// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//
// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Return:
//
// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]
// Note: For the return value, each inner list's elements must follow the lexicographic order.

public class Solution{
    public List<List<String>> groupStrings(String[] strings) {
      List<List<String>> res = new ArrayList<List<String>>();
      Map<String, List<String>> map = new HashMap();
      for (String s : strings){
        String key = getPattern(s);
        if (map.get(key) == null){
          map.put(key, new ArrayList());
        }
        map.get(key).add(s);
      }
      for (String key : map.keySet()){
        List<String> cur = map.get(key);
        Arrays.sort(cur);
        res.add(cur);
      }
      return res;
    }
    private String getPattern(String s){
      if (s.length() == 1) return "";
      StringBuilder = new StringBuilder();
      for (int i = 1; i < s.length(); i++){
        s.append((s.charAt(i)-s.charAt(i-1) + "#");
      }
      return s.toString();
    }
}
