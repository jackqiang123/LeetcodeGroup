// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
//
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
    public String convert(String s, int row) {
        if (row <= 1) return s;
        StringBuilder res = new StringBuilder();
        int gap = 2*row - 2;
        for (int i = 0; i < row; i++)
        {
          if (i == 0 || i == row - 1)
          {
            for (int j = i; j < s.length(); j+=gap)
              res.append(s.charAt(j));
          }
          else {
            for (int j = i; j < s.length(); j+=gap)
            {
               res.append(s.charAt(j));
               if (j + gap - i * 2 < s.length())
                  res.append(s.charAt(j + gap - i * 2));
            }
          }
        }
        return res.toString();
    }
}
