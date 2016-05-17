// Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
// For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
public class Solution {
    public List<String> findMissingRanges(int[] vals, int start, int end) {
      List<String> res = new ArrayList<String>();
      int i = 0; int j = 0;
      while(j < vals.length){
        if (j == 0 || vals[j] == vals[j - 1] + 1)
          j++;
        else {
          int nstart = i == 0 ? start : vals[i-1] + 1;
          int nend = vals[i] - 1;
          if (nstart == nend)
          {
            res.add(nstart);
          }
          else if (nstart < nend){
            String cur = nstart + "->" + nend;
            res.add(cur);
          }
          j++;
          i = j;
        }
      }
      return res;
    }
  }
