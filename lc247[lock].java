// A strobogrammatic number is a number that looks the same when rotated 180
// degrees (looked at upside down).
//
// Find all strobogrammatic numbers that are of length = n.
//
// For example,
// Given n = 2, return ["11","69","88","96"].
//
// Hint:
//
// Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
public class Solution{
  Map<Character, Character> map = new HashMap();
  map.put("0", "0");
  map.put("1", "1");
  map.put("8", "8");
  map.put("6", "9");
  map.put("9", "6");
  public List<String> findStrobogrammatic(int n){
    if (n == 0) return new ArrayList<String>().add("");
    if (n == 1) {
      List<String> res = new ArrayList();
      res.add("0");
      res.add("1");
      res.add("8");
      return res;
    }
    else{
      List<String> res = new ArrayList();
      List<String> innerList = findStrobogrammatic(n - 2);
      for (String cur : innerList){
        for (String c : map.keySet()){
          res.add(c + cur + map.get(c));
        }
      }
      return res;
    }
  }
}
