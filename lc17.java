// Given a digit string, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList<String>();
      if (digits.length() == 0) return res;
      HashMap<Character,List<Character>> map = new HashMap<Character,List<Character>>();
      String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      helper(digits, res, new ArrayList<Character>(), 0, mapping);
      return res;
    }
    private void helper(String digits, List<String> res, List<Character> cur, int start, String[]mapping){
      if (start == digits.length()) {
        res.add(convert(cur));
        return;
      }
      char c = digits.charAt(start);
      String curList = mapping[c-'0'];
      for (int i = 0; i < curList.length(); i++){
        cur.add(curList.charAt(i));
        helper(digits, res, cur, start + 1,mapping);
        cur.remove(cur.size() - 1);
      }
    }
    private String convert(List<Character> list){
      StringBuilder res = new StringBuilder();
      for (char c : list)
        res.append(c);
      return res.toString();
    }
}
