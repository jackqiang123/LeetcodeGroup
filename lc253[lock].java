// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find
// the minimum number of conference rooms required.
//
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
          return i1.start - i2.start;
        }
      });
      PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
          return i1.end - i2.end;
        }
      });
      pq.add(intervals[0]);
      for (int i = 1; i < intervals.length; i++){
        Interval interval = pq.remove();
        if (interval[i].start >= interval.end){
          interval.end = interval[i].end;
        }else{
          pq.add(intervals[i]);
        }
        pq.add(interval);
      }
      return pq.size();
    }
  }
