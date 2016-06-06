// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
// For example:
// Given "25525511135",
//
// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
      res = new ArrayList<String>();
      dfs(s, 0, new ArrayList<String>());
      return res;
    }
    private void dfs(String s, int start, ArrayList<String> cur){
      if (start == s.length()) {
        if (cur.size() == 4){
          res.add(getListResult(cur));
        }
      }
      else if (cur.size() >= 4) return;
      else{
          int maxBit = s.charAt(start) == '0' ? 1 : 3;
          for (int i = 1; i <= maxBit && i + start <= s.length(); i++){
            String curString = s.substring(start, i+start);
            if (Integer.parseInt(curString) <= 255){
              cur.add(curString);
              dfs(s, i + start, cur);
              cur.remove(cur.size()-1);
            }
          }
      }
    }

    private String getListResult(List<String> cur){
      StringBuilder res = new StringBuilder();
      res.append(cur.get(0)).append('.');
      res.append(cur.get(1)).append('.');
      res.append(cur.get(2)).append('.');
      res.append(cur.get(3));
      return res.toString();
    }
}
