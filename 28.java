// Implement strStr().
//
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// impement KMP algorithm
public class Solution {
    public int strStr(String haystack, String needle) {
      int hlen = haystack.length();
      int nlen = needle.length();
      if (nlen == 0) return 0;
      if (nlen > hlen) return -1;
      int []next = buildTable(needle);
      int i = 0, j = 0;
      while(i < haystack.length() && j < nlen){
        if (j == -1||haystack.charAt(i) == needle.charAt(j)){i++; j++;
        }
        else {
          j = next[j];
        }
      }
      if (j == nlen) return i-j;
      return -1;
    }
    private int []buildTable(String pattern){
      int []next = new int[pattern.length()];
      next[0] = -1;
      int j = 0;
      int k = -1;
      while(j < pattern.length() - 1){
        if (k == -1 || pattern.charAt(j) == pattern.charAt(k)){
          next[++j] = ++k;
        }
        else {
          k = next[k];
        }
      }
      return next;
    }
}
