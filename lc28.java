// Implement strStr().
//
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class Solution {
    public int strStr(String haystack, String needle) {
      int hlen = haystack.length();
      int nlen = needle.length();
      if (hlen < nlen) return -1;
      if (hlen == 0 && nlen == 0) return 0;
      int i = 0, j = 0;
      while(i + nlen - 1 < hlen){
        for (j = 0; j < nlen; j++){
          if (haystack.charAt(i+j) == needle.charAt(j)) continue;
          else {i++;break;}
        }
        if (j == nlen) return i;
      }
      return -1;
    }
}
