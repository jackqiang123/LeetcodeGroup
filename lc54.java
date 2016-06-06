// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// For example,
// Given the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> res = new ArrayList<Integer>();
      int h = matrix.length;
      if (h == 0) return res;
      int w = matrix[0].length;
      int i = 0;
      int j = 0;
      while(true){
          for (int k = 0; k < w; k++){
            res.add(matrix[i][j++]);
          }
          h--;j--;i++;
          if (h <= 0) return res;
          for (int k = 0; k < h; k++){
            res.add(matrix[i++][j]);
          }
          w--; i--;j--;
          if (w <= 0) return res;
          for (int k = 0; k < w; k++){
            res.add(matrix[i][j--]);
          }
          h--; j++;i--;
          if (h <= 0) return res;
          for (int k = 0; k < h; k++){
            res.add(matrix[i--][j]);
          }
          w--; i++;j++;
          if (w <= 0) return res;
      }
    }
}
