// Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
//
// For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
//
// [1, 1]
// [1, 1], [3, 3]
// [1, 1], [3, 3], [7, 7]
// [1, 3], [7, 7]
// [1, 3], [6, 7]
// Follow up:
// What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    /** Initialize your data structure here. */
    // use a linear structure to store interval is low efficient to maintain dynamic data
    // therefore, we consider a tree
    TreeMap<Integer, Interval> tree;
    public SummaryRanges() {
      tree = new TreeMap();
    }

    public void addNum(int val) {
      if (tree.get(val) != null) return;
      Integer floor = tree.lowerKey(val);
      Integer ceiling = tree.higherKey(val);
      if (floor != null && ceiling != null && tree.get(floor).end + 1 == val && tree.get(ceiling).start == val + 1){
        tree.get(floor).end = tree.get(ceiling).end;
        tree.remove(ceiling);
      }
      else if (floor != null && tree.get(floor).end + 1 >= val)
        tree.get(floor).end = Math.max(tree.get(floor).end, val);
      else if (ceiling != null && tree.get(ceiling).start - 1 == val)
      {  tree.put(val, new Interval(val, tree.get(ceiling).end));
         tree.remove(ceiling);
       }
       else tree.put(val, new Interval(val, val));
      // the code below incurs two tree operations, thus it if low efficient
      // if (floor != null && tree.get(floor).end + 1 == val){
      //     tree.get(floor).end++;
      // }
      // else {
      //     floor = val;
      //     tree.put(val, new Interval(val, val));
      // }
      //
      // if (ceiling != null && tree.get(ceiling).start - 1 == tree.get(floor).end){
      //   tree.get(floor).end = tree.get(ceiling).end;
      //   tree.remove(ceiling);
      // }
    }

    public List<Interval> getIntervals() {
      return new ArrayList<>(tree.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
