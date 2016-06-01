// Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
// Example:
// (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
// (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//
// Note:
// You may assume all input has valid answer.
//
// Follow Up:
// Can you do it in O(n) time and/or in-place with O(1) extra space?

public class Solution {
    public void wiggleSort(int[] nums) {
      Arrays.sort(nums);//can use quick selection to do it
      int len = nums.length;
      int mid = (len-1)/2;
      int []temp = new int[len];
      for (int i = 0; i < len; i++)
        temp[i] = nums[i];
      int i = mid;
      int j = len - 1;
      int pos = 0;
      while(true){
        nums[pos++] = temp[mid--];
        if (pos >= len) return;
        nums[pos++] = temp[j--];
        if (pos >= len) return;
      }
    }
}
