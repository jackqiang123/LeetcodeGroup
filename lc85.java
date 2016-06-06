// Given a 2D binary matrix filled with 0's and 1's,
// find the largest rectangle containing all ones and return its area.
public class Solution {
    public int maximalRectangle(char[][] matrix) {
      int h = matrix.length;
      if (h == 0) return 0;
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

    private int histgram(int []heights) {
      Stack<Integer> stack = new Stack<Integer>();
      int res = 0;
      for (int i = 0; i < heights.length; i++){
        if (stack.isEmpty()) stack.push(i);
        else {
          while(true){
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
            {
              stack.push(i); break;
            }
            else{
              int left = stack.pop();
              int leftboundary = stack.isEmpty() ? -1 : stack.peek();
              res = Math.max(res, (i - leftboundary - 1)*heights[left]);
            }
          }
        }
      }
      int right = heights.length;
      while(!stack.isEmpty()){
        int left = stack.pop();
        int leftboundary = stack.isEmpty() ? -1 : stack.peek();
        res = Math.max(res, (right - leftboundary - 1)*heights[left]);
      }
      return res;
    }
}
