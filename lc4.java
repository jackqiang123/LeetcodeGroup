// There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
//
// Subscribe to see which companies asked this question


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1)
        return helper(nums1, 0, m - 1, nums2, 0, n-1, (m+n-1)/2);
        else return (helper(nums1, 0, m - 1, nums2, 0, n-1, (m+n-1)/2) + helper(nums1, 0, m - 1, nums2, 0, n-1, (m+n-1)/2+1))/2.0;
    }

    private int helper(int nums1[], int l1, int h1, int nums2[], int l2, int h2, int rank){
        if (l1 > h1) return nums2[l2 + rank];
        if (l2 > h2) return nums1[l1 + rank];
        if (rank == 0) return nums1[l1] < nums2[l2] ? nums1[l1] : nums2[l2];
        int len1 = h1 - l1 + 1;
        int len2 = h2 - l2 + 1;
        int r1 = (len1 * rank)/(len1 + len2);
        int r2 = rank - r1 - 1;
        if (nums1[l1 + r1] == nums2[l2 + r2]) return nums1[l1 + r1];
        else if (nums1[l1 + r1] < nums2[l2 + r2]) return helper(nums1, l1 + r1 + 1, h1, nums2, l2, h2, rank - r1 - 1);
        else return  helper(nums1, l1, h1, nums2, l2 + r2+1, h2, rank - r2 - 1);
    }
}
