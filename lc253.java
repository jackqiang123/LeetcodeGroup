// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find
// the minimum number of conference rooms required.
//
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.
public class Solution {
    class Time{
      int time;
      boolean isStart;
      public Time(int time, boolean isStart){
        this.time = time; this.isStart = isStart;
      }
    }
    public int minMeetingRooms(Interval[] intervals) {
      List<Time> list = new ArrayList<Time>();
      for (Interval i : intervals){
        list.add(new Time(i.start, true));
        list.add(new Time(i.end, false));
      }
      Arrays.sort(list, new Comparator<Time>(){
        public int compare(Time i1, Time i2){
          return i1.time - i2.time;
        }
      });
      int max = 0;
      int count = 0;
      for (Time i : list){
        if (i.isStart){
          count++;
          max = Math.max(max, count);
        }
        else count--;
      }
      return max;
    }
  }
