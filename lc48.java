// You are given an n x n 2D matrix representing an image.
//
// Rotate the image by 90 degrees (clockwise).
//
// Follow up:
// Could you do this in-place?

public class Solution {
    public void rotate(int[][] matrix) {
      int len = matrix.length;
      for (int i = 0; i < len/2; i++){
        for (int j = 0; j < len; j++)
        swap(matrix, i, j, len - 1 - i, j);
      }
      for (int i = 0; i < len; i++){
        for (int j = 0; j < i; j++){
          swap(matrix, i, j, j, i);
        }
      }
    }
    private void swap(int[][]matrix, int i, int j, int p, int q){
      int t = matrix[i][j];
      matrix[i][j] = matrix[p][q];
      matrix[p][q] = t;
    }
}
