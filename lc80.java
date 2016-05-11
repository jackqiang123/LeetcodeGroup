// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array nums = [1,1,1,2,2,3],
//
// Your function should return length = 5, with the first five elements of nums
//being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeDuplicates(int[] nums) {
      int len = nums.length;
      if (len <= 2) return 2;
      int index = 1;
      int count = 1;
      for (int i = 1; i < len; i++){
        if (nums[i] != nums[i-1]) {nums[index++] = nums[i]; count = 1;}
        else {
          if (count == 1) {nums[index++] = nums[i];  count++;}
        }
      }
      return index;
    }
}
