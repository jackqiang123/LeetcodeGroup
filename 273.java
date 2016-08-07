// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
//
// For example,
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// Hint:
//
// Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
// Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.

public class Solution {
    String []lessThan20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                        "Nineteen", "Twenty"};
    String []lessThanHundred = {"","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String []thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
      String res = "";
      int bit = 0;
      while(num != 0){
        int cur3bit = num%1000;
        String curRead = read3bit(cur3bit).trim();
        if (curRead.length() != 0)
          res=  read3bit(cur3bit).trim() + " "+ thousands[bit] + " " + res;
        bit++;
        num /= 1000;
      }
      return res.trim();
    }
    private String read3bit(int num){
      if (num == 0) return "";
      if (num <= 20) return lessThan20[num];
      else if (num < 100) return lessThanHundred[num/10] + " " + read3bit(num%10);
      else return lessThan20[num/100] + " Hundred" + " " + read3bit(num%100);
    }
}
