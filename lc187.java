// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
// for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
// repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings) that
// occur more than once in a DNA molecule.
//
// For example,
//
// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      List<String> res = new ArrayList<String>();
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i + 10 <= s.length(); i++)
      {
        String cur = s.substring(i, i + 10);
        int code = enCode(cur);
        if (map.get(code) == null)
          map.put(code,1);
        else if (map.get(code) == 1){
          res.add(cur);
          map.put(code,2);
        }
        else map.put(code, map.get(code) + 1);
      }
      return res;
    }
    private int enCode(String s){
      int res = 0;
      for (int i = 0; i < 10; i++){
        char c = s.charAt(i);
        if (c == 'A')
          res = res * 4;
        else if (c == 'T')
          res = res * 4 + 1;
        else if (c == 'G')
          res = res * 4 + 2;
        else res = res * 4 + 3;
      }
      return res;
    }
}
