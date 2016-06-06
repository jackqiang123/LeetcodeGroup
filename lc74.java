// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//     Integers in each row are sorted from left to right.
//     The first integer of each row is greater than the last integer of the previous row.
//
// For example,
//
// Consider the following matrix:
//
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
//
// Given target = 3, return true.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int h = matrix.length;
      if (h == 0) return false;
      int w = matrix[0].length;
      int lo = 0;
      int hi = h*w-1;
      while(lo < hi){
        int mid = (lo + hi)/2;
        int x = mid/w;
        int y = mid%w;
        if (matrix[x][y] == target) return true;
        else if (matrix[x][y] < target) lo = mid + 1;
        else hi = mid;
      }
      return matrix[lo/w][lo%w] == target;
    }
}
