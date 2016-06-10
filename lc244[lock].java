// This is a follow up of Shortest Word Distance. The only difference is now you are given the
// list of words and your method will be called repeatedly many times with different parameters.
// How would you optimize it?
//
// Design a class which receives a list of words in the constructor, and implements a method
// that takes two words word1 and word2 and return the shortest distance between these two words in the list.
//
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Given word1 = "coding”, word2 = "practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.
//
// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class Solution {
    Map<String, List<Integer>> map;
    public int shortestDistance(String[] words, String word1, String word2) {
      if (map == null) {
          map = new HashMap();
        for (int i = 0; i < words.length; i++){
          if (map.get(words[i]) == null){
            List<Integer> index = new ArrayList();
            index.add(i);
            map.put(words[i], i);
          }
          else map.get(words[i]).add(i);
        }
      }
      List<Integer> list1 = map.get(word1);
      List<Integer> list2 = map.get(word2);
      int best = 0;
      int i = 0;
      int j = 0;
      best = Math.abs(list1.get(0) - list2.get(0));
      while(i < list1.size() && j < list2.size()){
        if (list1.get(i) < list2.get(j)){
          i++;
        }
        else{
          j++;
        }
        if (i < list1.size() && j < list2.size())
          best = Math.min(best, Math.abs(list1.get(i) - list2.get(j)));
      }
      return best;
    }
  }
