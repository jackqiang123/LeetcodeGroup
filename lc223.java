// Find the total area covered by two rectilinear rectangles in a 2D plane.
//
// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
// Rectangle Area
//
// Assume that the total area is never beyond the maximum possible value of int.

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
      int area1 = (C-A)*(D-B);
      int area2 = (G-E)*(H-F);
      int sumArea = area1 + area2;
      if (C <= E || A >= G || B >= H || D <= F) return sumArea;
      int x1 = Math.max(A,E);
      int y1 = Math.max(B,F);
      int x2 = Math.min(C,G);
      int y2 = Math.min(D,H);
      return sumArea - (x2-x1)*(y2-y1);

    }
}
