// Given a 2D binary matrix filled with 0's and 1's,
// find the largest rectangle containing all ones and return its area.
public class Solution {
    public int maximalRectangle(char[][] matrix) {
      int h = matrix.length;
      int w = matrix[0].length;
      int input[] = new int[w];
      int max = 0;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (matrix[i][j] == '0') input[j] = 0;
          else input[j] += 1;
        }
        max = Math.max(max, histgram(input));
      }
      return max;
    }

    private int histgram(int []input){
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < heights.length; i++){
          if (stack.isEmpty()) stack.push(i);
          else {
            while(true){
              if (stack.isEmpty() || stack.peek() <= heights[i])
              {
                stack.push(i); break;
              }
              else{
                int left = stack.pop();
                res = Math.max(res, (i -left)*heights[left]);
              }
            }
          }
        }
        int right = heights.length;
        while(!stack.isEmpty()){
          int left = stack.pop();
          res = Math.max(res, (right - left)*heights[left]);
        }
        return res;

    }
}
