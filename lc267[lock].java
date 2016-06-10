// Given a string s, return all the palindromic permutations (without duplicates) of it.
// Return an empty list if no palindromic permutation could be form.
//
// For example:
//
// Given s = "aabb", return ["abba", "baab"].
//
// Given s = "abc", return [].
//
// Hint:
//
// If a palindromic permutation exists, we just need to generate the first half of the string.
// To generate all distinct permutations of a (half of) string, use a similar approach from:
// Permutations II or Next Permutation.
public class Solution{
  int []count;
  List<String> res;
  char median = '';
  public List<String> generatePalindromes(String s) {
    res = new ArrayList<String>();
    if (!canPermutePalindrome(s)) return res;
    if (s.length()%2 == 1){
      for (int i = 0; i < count.length; i++)
        if (count[i] % 2 == 1){
          median = (char)('a'+i);
          break;
        }
    }
    for (int i = 0; i < count.length; i++)
      count[i] /= 2;
    dfs(new StringBuilder(), s.length()/2);
    return res;
  }

  private String getResult(StringBuilder sb){
    sb.append(median).append(sb.reverse());
    return sb.toString();
  }

  private void dfs(StringBuilder sb, int len){
    if (len == 0){
      res.add(getResult(sb));
    }
    else{
      for (int i = 0; i < 26; i++){
        if (count[i] != 0){
          count[i]--;
          dfs(sb.append((char)('a' + i)), len - 1);
          count[i]++;
        }
      }
    }
  }

  private boolean canPermutePalindrome(String s) {
    int []count = new int[26];
    for (int i = 0; i < s.length(); i++)
      coutn[s.charAt(i) - 'a']++;
    int odd = 0;
    for (int i : count){
      if (i%2 == 1)
        odd++;
    }
    return s.length()%2==0?(odd==0):(odd==1);
  }
}
