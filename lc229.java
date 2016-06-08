// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// The algorithm should run in linear time and in O(1) space.
//
// Hint:
//
//     How many majority elements could it possibly have?
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
      int c1 = 0;
      int c2 = 0;
      if (nums.length == 0) return new ArrayList<Integer>();
      int n1 = nums[0]+1;
      int n2 = nums[0]-1;
      for (int i : nums){
        if (c1 == 0 && i != n2){
          n1 = i;
        }
        else if (c2 == 0 && i != n1){
          n2 = i;
        }
        if (i == n1){
          c1++;
        }
        else if (i == n2) {
          c2++;
        }
        else {
          c1--;c2--;
        }
      }
      List<Integer> res = new ArrayList<Integer>();
      if (isMajor(nums, n1)) res.add(n1);
      if (isMajor(nums, n2)) res.add(n2);
      return res;
    }
    private boolean isMajor(int []nums, int n){
      int c = 0;
      for (int i : nums){
        if (i == n) c++;
      }
      return c > nums.length/3;
    }
}
