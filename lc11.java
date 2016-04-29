// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate
 // (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 // Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container.
public class Solution {
  // since we want to reduce the botteneck of two sides, thus we are going do it greedy.
    public int maxArea(int[] height) {
      int res = 0;
      int i = 0;
      int j = height.length - 1;
      while(i < j){
        res = Math.max(res, (j-i)* Math.min(height[j], height[i]));
        if (height[j] < height[i]) j--;
        else i++;
      }
      return res;
    }
}
