// Given a roman numeral, convert it to an integer.
//
// Input is guaranteed to be within the range from 1 to 3999.
public class Solution {
    int[] sizes = {1, 5, 10, 50, 100, 500, 1000};
    char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    Map<Character, Integer> map = new HashMap<>();
    {
      map.put('I',1);
      map.put('V',5);
      map.put('X',10);
      map.put('L',50);
      map.put('C',100);
      map.put('D',500);
      map.put('M',1000);
    }
    public int romanToInt(String s) {
      int res = 0;
      for (int i = s.length() - 1; i >= 0; i--){
        char c = s.charAt(i);
        res += (map.get(c));
        if (i != s.length() - 1 && map.get(c) < map.get(s.charAt(i+1)))
          res-=(2*map.get(c));
      }
      return res;
    }
}
