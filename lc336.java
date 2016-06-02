// Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
// so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
      Map<String, Integer> map = new HashMap();
      List<List<Integer>> res = new ArrayList();
      for (int i = 0; i < words.length; i++) map.put(words[i], i);
      for (int i = 0; i < words.length; i++){
        for (int j = 0; j <= words[i].length(); j++){
          String cur1 = words[i].substring(0,j);
          String cur2 = words[i].substring(j);
          if (isPalindrome(cur1)){
            String otherPart = new StringBuilder(cur2).reverse().toString();
            if (map.get(otherPart) != null && map.get(otherPart) != i){
              List<Integer> array = Arrays.asList(map.get(otherPart), i);
              res.add(array);
            }
          }
          if (isPalindrome(cur2)){
            String otherPart = new StringBuilder(cur1).reverse().toString();
            if (map.get(otherPart) != null && map.get(otherPart) != i && cur2.length()!=0 ){
              List<Integer> array = Arrays.asList(i, map.get(otherPart));
              res.add(array);
            }
          }
        }
      }
      return res;
    }

    private boolean isPalindrome(String s){
      int i = 0; int j = s.length() - 1;
      while(i < j){
        if (s.charAt(i) != s.charAt(j)) return false;
        i++; j--;
      }
      return true;
    }
}
