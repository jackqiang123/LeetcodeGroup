// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.
//
// For example, Given [[0, 30],[5, 10],[15, 20]], return false.

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
      // can be sort in both start or end.
      Arrays.sort(interval, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
          return i1.end - i2.end;
        }
      });
      // finding there is no overlap or not.
      for (int i = 0; i < intervals.size() - 1; i++){
        if (intervals.get(i).end <= intervals.get(i+1).start)
          continue;
        else return false;
      }
      return true;
    }
  }
