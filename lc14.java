// Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
      int len = strs.length;
      if (len <= 0) return "";
      int index = strs[0].length();
      for (int i = 1; i < len; i++){
          index = Math.min(index, strs[i].length());
          for (int j = 0; j < index; j++){
            if (strs[0].charAt(j) != strs[i].charAt(j)){
              index = j; break;
            }
          }
      }
      return strs[0].substring(0, index);
    }
}
