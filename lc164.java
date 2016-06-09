// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//
// Try to solve it in linear time/space.
//
// Return 0 if the array contains less than 2 elements.
//
// You may assume all elements in the array are non-negative integers and
// fit in the 32-bit signed integer range.
public class Solution {
    public int maximumGap(int[] nums) {
      if (nums.length <= 1) return 0;
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      for (int i : nums)
      {
        max = Math.max(max,i);
        min = Math.min(min,i);
      }
      int gap = max - min;
      if (gap == 0) return 0;
      int bucketSize = gap/nums.length;
      if (bucketSize == 0) bucketSize = 1;
      int numofBucket = gap/bucketSize + 1;
      int maxArray[] = new int[numofBucket];
      Arrays.fill(maxArray, Integer.MIN_VALUE);
      int minArray[] = new int[numofBucket];
      Arrays.fill(minArray, Integer.MAX_VALUE);
      int res = 0;
      for (int n : nums){
        int index = (n - min)/bucketSize;
        maxArray[index] = Math.max(maxArray[index], n);
        minArray[index] = Math.min(minArray[index], n);
      }

      int left = minArray[0];
      int right = maxArray[0];
      int best = bucketSize;
      for (int i = 0; i < maxArray.length; i++){
        if (maxArray[i] != Integer.MIN_VALUE){
          left = minArray[i];
          best = Math.max(best, left - right);
          right = maxArray[i];
        }
      }
      return best;
    }
}
