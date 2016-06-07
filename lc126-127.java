// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
//    Only one letter can be changed at a time
//    Each intermediate word must exist in the word list
//
// For example,
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
//
// Return
//
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]
//
// Note:
//
//    All words have the same length.
//    All words contain only lowercase alphabetic characters.
public class Solution {
    List<List<String>> res;
    Map<String, List<String>> prefix;
    Map<String, Integer> distance;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
      res = new ArrayList<List<String>>();
      prefix = new HashMap<String, List<String>>();
      distance = new HashMap<String, Integer>();
      Queue<String> queue = new LinkedList<String>();
      queue.add(beginWord);
      distance.put(beginWord, 0);
      int targetDistance = Integer.MAX_VALUE;
      while(!queue.isEmpty()){
        String cur = queue.remove();
        List<String> neigb = getNei(cur, wordList);
        if (distance.get(cur) > targetDistance) break;
        for (String n : neigb){
          if (distance.get(n) == null || distance.get(n) == distance.get(cur) + 1){
            if (distance.get(n) == null) queue.add(n);
            distance.put(n, distance.get(cur) + 1);
            if (n.equals(endWord)) targetDistance = Math.min(targetDistance, distance.get(endWord));
            if (prefix.get(n) == null) prefix.put(n, new ArrayList<String>());
            prefix.get(n).add(cur);
          }
        }
      }
      ArrayList<String> cur = new ArrayList<String>();
      dfs(beginWord, endWord, cur);
      return res;
    }

    private void dfs(String beginWord, String endWord, ArrayList<String> cur){
      if (endWord.equals(beginWord)){
        List<String> curList = new ArrayList<String>(cur);
        curList.add(0, beginWord);
        res.add(curList);
      }
      else {
        List<String> prefixList = prefix.get(endWord);
        cur.add(0, endWord);
        if (prefixList != null){
        for (String prefixWord : prefixList){
          dfs(beginWord, prefixWord, cur);
        }
        }
        cur.remove(0);
      }
    }

    private List<String> getNei(String s, Set<String> wordList){
      List<String> list = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++){
        for (char c = 'a'; c <= 'z'; c++){
          char[]array = s.toCharArray();
          array[i] = c;
          String ss = new String(array);
          if (!ss.equals(s) && wordList.contains(ss))
            list.add(ss);
        }
      }
      return list;
    }
}
