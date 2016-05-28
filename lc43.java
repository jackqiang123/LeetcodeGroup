// Given two numbers represented as strings, return multiplication of the numbers as a string.
//
// Note:
//
//     The numbers can be arbitrarily large and are non-negative.
//     Converting the input string to integer is NOT allowed.
//     You should NOT use internal library such as BigInteger.
public class Solution {
    public String multiply(String num1, String num2) {
      int len1 = num1.length();
      int len2 = num2.length();
      int [] res = new int[len1 + len2];
      for (int i = len1 - 1; i >= 0; i--){
        int c = (int)(num1.charAt(i) - '0');
        for (int j = len2 - 1; j >= 0; j--){
          res[i + j + 1] += c * (int)(num2.charAt(j) - '0');
        }
      }
      for (int i = res.length - 1; i >= 0; i--){
        if (res[i] >= 10) {
          int bit = res[i]%10;
          int nextbit = res[i]/10;
          res[i] = bit;
          res[i-1] += nextbit;
        }
      }
      StringBuilder resVal = new StringBuilder();
      int i = 0;
      for (i = 0; i < res.length; i++){
        if (res[i] != 0) break;
      }
      if (i == res.length) return "0";
      else {
        for (; i < res.length; i++)
          resVal.append(res[i]);
        return resVal.toString();
      }
    }
}
