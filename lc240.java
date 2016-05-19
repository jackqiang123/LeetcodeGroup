// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// For example,
//
// Consider the following matrix:
//
// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]
// Given target = 5, return true.
//
// Given target = 20, return false.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int h = matrix.length;
      int w  = matrix[0].length;
      int i = 0;
      int j = w - 1;
      while(i < h && j >= 0){
        int base = matrix[i][j];
        if (base == target) return true;
        if (base > target) j--;
        else i++;
      }
      return false;
    }
}
