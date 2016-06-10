// Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
// For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
public class Solution {
	    public List<String> findMissingRanges(int[] nums, int start, int end) {
	      List<String> res = new ArrayList<String>();
	      for (int i = 0; i <= nums.length; i++){
	    	  int lower = i == 0 ? start : nums[i-1]+1;
	    	  int higher = i == nums.length ? start : nums[i-1] - 1;
	    	  addMissing(lower, higher, res);
	      }
	      return res;
	    }

		private void addMissing(int lower, int higher, List<String> res) {
			if (lower > higher) return; // this steps jump over unnecessary interval
			if (lower == higher) res.add(lower+"");
			else res.add(lower+"->"+higher);
		}
}
