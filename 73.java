// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class Solution {
    public void setZeroes(int[][] matrix) {
      boolean firstRow = false;
      boolean firstCol = false;
      int h = matrix.length;
      if (h == 0) return;
      int w = matrix[0].length;
      for (int i = 0; i < w; i++){
        if (matrix[0][i] == 0) {firstRow = true; break;}
      }
      for (int i = 0; i < h; i++){
        if (matrix[i][0] == 0) {firstCol = true; break;}
      }
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (matrix[i][j] == 0){
            matrix[i][0] = 0; matrix[0][j] = 0;
          }
        }
      }
      for (int i = 1; i < h; i++){
        for (int j = 1; j < w; j++){
          if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        }
      }
      if (firstRow) {
        for (int i = 0; i < w; i++) matrix[0][i] = 0;
      }
      if (firstCol) {
        for (int i = 0; i < h; i++) matrix[i][0] = 0;
      }
    }
}
