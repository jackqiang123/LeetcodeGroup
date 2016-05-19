// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
//
// Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
      int len = words.length;
      int best = len;
      int i = 0; int j = 0;
      while(i < len && j < len){
        if (!words[i].equals(word1) && !words[i].equals(word2)){
          i++;
        }
        else{

        }
      }
      return best;
    }
  }
