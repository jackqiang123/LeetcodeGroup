// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
// click to show follow up.
// Follow up:
//
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
public class Solution {
    public void setZeroes(int[][] matrix) {
      boolean row0 = false;
      boolean col0 = false;
      int h = matrix.length;
      int w = matrix[0].length;
      for (int i = 0; i < h; i++)
      {
        if (matrix[i][0] == 0){ col0 = true; break; }
      }
      for (int j = 0; j < w; j++){
        if (matrix[0][j] == 0) { row0 = true; break; }
      }
      for (int i = 1; i < h; i++){
        for (int j = 1; j < w; j++){
          if (matrix[i][j] == 0){
            matrix[0][j] = 0;
            matrix[i][0] = 0;
          }
        }
      }
      for (int i = 1; i < h; i++){
        if (matrix[i][0] == 0){
          for (int j = 1; j < w; j++)
            matrix[i][j] = 0;
        }
      }
      for (int j = 1; j < w; j++){
        if (matrix[0][j] == 0){
          for (int i = 1; i < h; i++)
            matrix[i][j] = 0;
        }
      }

      if (col0){
        for (int i = 0; i < h; i++){
          matrix[i][0] = 0;
        }
      }
      if (row0){
        for (int j = 0; j < w; j++)
        {
          matrix[0][j] = 0;
        }

      }

    }
}
