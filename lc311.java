// Given two sparse matrices A and B, return the result of AB.
//
// You may assume that A's column number is equal to B's row number.
//
// Example:
//
// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]
//
// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]
//
//
//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |
public class Solution{
 int[][] multiply(int [][]A, int [][] B) {
    int h = A.length;
    int m = A[0].length;
    int w = B[0].length;
    int [][] res = new int[h][w];
    for (int i = 0; i < h; i++){
      for (int j = 0; j < m; j++){
        if (A[i][j] == 1){
          for (int k = 0; k < m; k++)
            res[i][k] += (A[i][j]*B[j][k]);
        }
      }
    }
    return res;
 }
}
