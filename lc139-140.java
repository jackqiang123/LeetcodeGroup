// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
// Return all such possible sentences.
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
//
// A solution is ["cats and dog", "cat sand dog"].
public class Solution {
    List<String> res;
    public List<String> wordBreak(String s, Set<String> wordDict) {
      res = new ArrayList<String>();
      dfs(s, 0, wordDict, new ArrayList<String>());
      return res;
    }
    private void dfs(String s, int start, Set<String> wordDict, ArrayList<String> cur){
      if (start == s.length()){
        res.add(getResult(cur));
      }
      else{
        for (int i = start; i < s.length(); i++){
          String curString = s.subString(start, i + 1);
          if (wordDict.contains(curString)){
            cur.add(curString);
            dfs(s, i + 1, wordDict, cur);
            cur.remove(cur.size()-1);
          }
        }
      }
    }

    private String getResult(List<String> list){
      if (list.size() == 0) return "";
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < list.size(); i++){
        sb.append(list.get(i));
        if (i != list.size() - 1)
          sb.append(" ");
      }
      return sb.toString();
    }
}
