// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]
public class Solution {
    List<List<String>> res;
    Set<String> cache;
    public List<List<String>> partition(String s) {
      res = new ArrayList<List<String>>();
      cache = new HashSet<String>();
      dfs(s, 0, new ArrayList<String>());
      return res;
    }
    private void dfs(String s, int start, List<String> cur){
      if (start == s.length()){
        res.add(new ArrayList<String>(cur));
      }
      else {
        for (int i = start + 1; i <= s.length(); i++){
          if (isPal(s.substring(start, i))){
            cur.add(s.substring(start, i));
            dfs(s, i, cur);
            cur.remove(cur.size()-1);
          }
        }
      }
    }

    private boolean isPal(String s){
      if (cache.contains(s)) return true;
      int i = 0; int j = s.length() - 1;
      while(i < j){
        if (s.charAt(i) != s.charAt(j))
          return false;
        else {
          i++; j--;
        }
      }
      cache.add(s);
      return true;
    }
}
