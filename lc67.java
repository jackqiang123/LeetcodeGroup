// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100".

public class Solution {
    public String addBinary(String a, String b) {
      StringBuilder res = new StringBuilder();
      int alen = a.length();
      int blen = b.length();
      if (alen == 0) return b;
      if (blen == 0) return a;
      int i  = alen - 1;
      int j = blen - 1;
      int bit = 0;
      while(i >= 0 || j >= 0){
        if (i >= 0 && j >= 0){
          int x = (int)(a.charAt(i) - '0');
          int y = (int)(b.charAt(j) - '0');
          int cur = x + y + bit;
          bit = cur/2;
          res.insert(0, cur%2);
          i--; j--;
        }
        else if (i >= 0){
          int x = (int)(a.charAt(i) - '0');
          int y = 0;
          int cur = x + y + bit;
          bit = cur/2;
          res.insert(0, cur%2);
          i--;
        }
        else if (j >= 0){
          int x = 0;
          int y = (int)(b.charAt(j) - '0');
          int cur = x + y + bit;
          bit = cur/2;
          res.insert(0, cur%2);
          j--;
        }
      }
      if (bit != 0)
        res.insert(0, bit);
      return res.toString();
    }
}
