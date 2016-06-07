// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
      int sum = 0;
      for (int i = 0; i < points.length; i++){
        sum = Math.max(sum, findMax(i, points));
      }
      return sum;
    }
    private int findMax(int base, Point[] points){
      Map<Double, Integer> map = new HashMap<Double, Integer>();
      Point basePoint = points[base];
      int max = 0;
      int samePoint = 0;
      for (int i = 0; i < points.length; i++){
        if (i == base) continue;
        Point cur = points[i];
        if (cur.x == basePoint.x && cur.y == basePoint.y)
          samePoint++;
        else if (cur.x == basePoint.x){
          map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) == null ? 1 : map.get(Double.MAX_VALUE) + 1);
          max = Math.max(max, map.get(Double.MAX_VALUE));
        }
        else {
          double slope = (cur.y - basePoint.y)*1.0/(cur.x - basePoint.x)*1.0;
          map.put(slope, map.get(slope) == null ? 1 : map.get(slope) + 1);
          max = Math.max(max, map.get(slope));
        }

      }
      return 1 + max + samePoint;
    }
}
