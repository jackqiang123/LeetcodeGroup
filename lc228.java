// Given a sorted integer array without duplicates, return the summary of its ranges.
//
// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
public class Solution {
    public List<String> summaryRanges(int[] nums) {
      List<String> res = new ArrayList<String>();
      if (nums.length == 0) return res;
      int i = 0;
      int j = 0;
      while(j < nums.length){
        while ( i == j || (j < nums.length && nums[j] == nums[j-1] + 1)){
          j++;
        }
        if (i == j - 1){
          res.add(String.valueOf(nums[i]));
        }
        else {
          res.add(nums[i]+"->"+nums[j-1]);
        }
        i = j;
      }

      return res;
    }
}
