// Given two strings S and T, determine if they are both one edit distance apart.
//
// Hint:
// 1. If | n – m | is greater than 1, we know immediately both are not one-edit distance apart.
// 2. It might help if you consider these cases separately, m == n and m ≠ n.
// 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
//  If m > n, we could just simply swap S and T.
// 4. If m == n, it becomes finding if there is exactly one modified operation.
// If m ≠ n, you do not have to consider the delete operation. Just consider the insert operation in T.
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
      if (s.length() < t.length()) return isOneEditDistance(t, s);
      if (s.length() > t.length() + 1) return false;
      if (s.length () > t.length()){
        return isInsertTrue(s, t);
      }
      else return modifyOneTrue(s, t);
    }

    private boolean isInsertTrue(String s, String t){
      int diff = 0;
      int i = 0;
      while(i < t.length() && i + diff < s.length())
      {
        if (s.charAt(i+diff) != t.charAt(i))
          diff++;
        else i++;
      }
      return diff == 1;
    }

    private boolean modifyOneTrue(String s, String t){
      int diff = 0;
      for (int i = 0; i < s.length(); i++)
      {
        if (s.charAt(i) != t.charAt(i))
          diff++;
      }
      return diff == 1;
    }
  }
