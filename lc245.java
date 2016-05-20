// his is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// word1 and word2 may be the same and they represent two individual words in the list.
//
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.
//
// Note:
// You may assume word1 and word2 are both in the list.
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
      if (word1.equals(word2)){
        int best = words.length();
        int index = 0;
        int last = -len;
        while(index < words.length()){
          if (words[index].equals(word1)){
            best = Math.min(best, index - last);
            last = index;
          }
          else index++;
        }
        return best;
      }
      else return distinctSolution(words, word1, word2);
    }
    private int distinctSolution(String[] words, String word1, String word2){
        int len = words.length;
        int best = len;
        int i = 0; int j = 0;
        while(i < len && !words[i].equals(word1))
          i++;
        while(j < len && !words[j].equals(word2))
          j++;
        best = Math.abs(i - j);
        i++;
        j++;
        while(i < len && j < len){
          if (i < j){
            while(i < len && !words[i].equals(word1)){
              i++;
            }
          }
          else {
            while(j < len && !words[j].equals(word2)){
              j++;
            }
          }
          if (i < len && j < len){
            best = Math.min(best, Math.abs(i-j));
          }
        }
        return best;

    }
  }
