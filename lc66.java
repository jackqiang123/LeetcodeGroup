// Given a non-negative number represented as an array of digits, plus one to the number.
//
// The digits are stored such that the most significant digit is at the head of the list.
public class Solution {
    public int[] plusOne(int[] digits) {
      int bit = 1;
      for (int i = digits.length - 1; i >= 0; i--){
        int cur = bit + digits[i];
        bit = cur/10;
        digits[i] = cur%10;
      }
      if (bit == 1){
        int []res = new int[digits.length + 1];
        res[0] = 1;
        return res;
      }
      return digits;
    }
}
