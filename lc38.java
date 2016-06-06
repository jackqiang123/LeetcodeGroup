// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
//
// Given an integer n, generate the nth sequence.
//
// Note: The sequence of integers will be represented as a string.

public class Solution {
    public String countAndSay(int n) {
      if (n == 1) return "1";
      String input = countAndSay(n-1);
      StringBuilder res = new StringBuilder();
      int i  = 1;
      char last = input.charAt(0);
      int count = 1;
      while(i < input.length()){
        if (input.charAt(i) == last) {count++;}
        else {
          res.append(count).append(last);
          last = input.charAt(i);
          count = 1;
        }
        ++i;
      }
      res.append(count).append(last);
      return res.toString();
    }
}
