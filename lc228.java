// Given a sorted integer array without duplicates, return the summary of its ranges.
//
// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
public class Solution {
    public List<String> summaryRanges(int[] nums) {
      List<String> res = new ArrayList<String>();
      int i = 0;
      int j = 0;
      while(j < nums.length){
        while (j == 0 || (j < nums.length && nums[j] == nums[j-1] + 1)){
          j++;
        }
        if (i == j - 1){
          res.add(nums[i]);
        }
        else {
          res.add(nums[i]+"->"+nums[j-1]);
        }
        i = j;
      }
      return res;
    }
}
