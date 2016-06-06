// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
// find the area of largest rectangle in the histogram.
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.
public class Solution {
    public int largestRectangleArea(int[] heights) {
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
