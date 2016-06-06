// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// For example,
// Given n = 3,
// You should return the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
public class Solution {
    public int[][] generateMatrix(int n) {
      int[][] res = new int[n][n];
      int num = 1;
      int i = 0;
      int j = 0;
      int h = n;
      int w = n;
      while(true){
        for (int k = 0; k < w; k++){
          res[i][j++] = num;
          num++;
        }
        h--;i++;j--;
        if (h <= 0) return res;
        for (int k = 0; k < h; k++){
          res[i++][j] = num;
          num++;
        }
        w--;i--;j--;
        if (w <= 0) return res;

        for (int k = 0; k < w; k++){
          res[i][j--] = num;
          num++;
        }
        h--;i--; j++;
        if (h <= 0) return res;

        for (int k = 0; k < h; k++){
          res[i--][j] = num;
          num++;
        }
        w--; i++;j++;
        if (w <= 0) return res;
      }
    }
}
