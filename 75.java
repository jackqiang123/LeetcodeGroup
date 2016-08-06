// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
public class Solution {
    public void sortColors(int[] nums) {
      int p1 = 0; int p2 = nums.length - 1;
      int i = 0;
      while(i <= p2){
        if (nums[i] == 0) swap(nums, p1++,i++);
        else if (nums[i] == 2) swap(nums, p2--, i);
        else i++;
      }
    }
    private void swap(int []nums, int i, int j){
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }
}
