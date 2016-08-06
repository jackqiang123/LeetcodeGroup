// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSelection(nums, 0, nums.length - 1, k-1);
    }

    private int quickSelection(int []nums, int start, int end, int rank){
      if (start == end) return nums[start];
      int pivot = (start + end)/2;
      int pivotIndex = partition(nums, pivot, start, end);
      if (pivotIndex == rank) return nums[pivotIndex];
      if (pivotIndex < rank) return quickSelection(nums, pivotIndex + 1, end, rank);
      return quickSelection(nums, start, pivotIndex - 1, rank);
    }

    private int partition(int []nums, int pivot, int start, int end){
      if (start == end) return start;
      swap(nums, start, pivot);
      int value = nums[start];
      int p = start + 1;
      for (int i = start + 1; i <= end; i++){
        if (nums[i] > value) swap(nums, i, p++);
      }
      swap(nums, start, --p);
      return p;
    }
    private void swap(int [] nums, int i, int j){
      int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
}
