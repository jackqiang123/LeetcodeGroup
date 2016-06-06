// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
      Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
          return i1.start - i2.start;
        }
      });
      List<Interval> res = new ArrayList<Interval>();

      for (Interval curInt : intervals){
        if (res.size() == 0) res.add(curInt);
        else{
          Interval lastInt = res.get(res.size() - 1);
          if (lastInt.end < curInt.start) res.add(curInt);
          else
            lastInt.end = Math.max(lastInt.end, curInt.end);
        }
      }
      return res;
    }
}
