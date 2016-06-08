// Given a range [m, n] where 0 <= m <= n <= 2147483647,
// return the bitwise AND of all numbers in this range, inclusive.
//
// For example, given the range [5, 7], you should return 4.
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      int bit = 0;
      while((n >> bit) != 0)
        bit++;
      if (bit == 0) return 0;
      bit--;
      int res = 0;
      while(bit >= 0)
      {
        if ((m >> bit) == (n >> bit))
        {
          res <<= 1;
          res += ((m >> bit) & 1);
          bit--;
        }
        else {
          res <<= (bit+1);
          return res;
        }
      }
      return res;
    }
}
