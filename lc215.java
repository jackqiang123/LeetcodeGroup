// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
// not the kth distinct element.
//
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSelection(nums, 0, nums.length - 1, k - 1);
    }
    private int quickSelection(int []nums, int start, int end, int rank){
      if (start == end) return nums[start];
      int pivotRank = parition(nums, start, end);
      if (pivotRank < rank) return quickSelection(nums, pivotRank + 1, end, rank);
      else if (pivotRank > rank) return quickSelection(nums, start, pivotRank - 1, rank);
      else return nums[pivotRank]
    }
    private int parition(int []nums, int start, int end){
      int j = start + 1;
      for (int i = start + 1; i <= end; i++){
        if (nums[i] > nums[start])
        {
          swap(nums, j++, i);
        }
      }
      j--;
      swap(nums, start, j);
      return j;
    }
    private void swap(int []nums, int i, int j){
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }
}
