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
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    private List<String> dfs(String s, Set<String> wordDict, HashMap<String, List<String>> cache){
      if (cache.get(s) != null){
        return cache.get(s);
      }
      else{
        List<String> res = new ArrayList();
        for (int i = 0; i < s.length(); i++){
          String curString = s.substring(0, i + 1);
          if (wordDict.contains(curString)){
            List<String> previous = dfs(s.substring(i+1), wordDict, cache);
            if (previous.size() != 0)
            {   for (String previousWord : previous){
                 res.add(curString + " " + previousWord);
                }
            }
            else if (i+1==s.length()){
                res.add(curString);
            }
          }
        }
        cache.put(s, res);
        return res;
      }
    }
}
