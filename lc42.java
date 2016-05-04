// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
public class Solution {
    public int trap(int[] height) {
      int len = height.length;
      if (len <= 2) return 0;
      int leftbar [] = new int [len];
      int rightbar [] = new int[len];
      for (int i = 0; i < len; i++){
        if (i == 0) leftbar[i] = height[i];
        else{
          leftbar[i] = Math.max(height[i], leftbar[i-1]);
        }
      }
      for (int i = len - 1; i >= 0; i--){
        if (i == len - 1) rightbar[i] = height[i];
        else{
          rightbar[i] = Math.max(height[i], rightbar[i+1]);
        }
      }
      int res = 0;
      for (int i = 0; i < len; i++){
        int bar = Math.min(leftbar[i], rightbar[i]);
        if (bar > height[i])
          res += (bar - height[i]);
      }
      return res;
    }
}
