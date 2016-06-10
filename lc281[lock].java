    // Given two 1d vectors, implement an iterator to return their elements
    // alternately. // For example, given two 1d vectors: // v1 = [1, 2] v2 =
    // [3, 4, 5, 6] // By calling next repeatedly until hasNext returns false,
    // the order of elements returned by next should be: [1, 3, 2, 4, 5, 6]. //
    // Follow up: What if you are given k 1d vectors? How well can your code be
    // extended to such cases? // Clarification for the follow up question -
    // Update (2015-09-18): The "Zigzag" order is not clearly defined and is
    // ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
    // replace "Zigzag" with "Cyclic". For example, given the following input: //
    // [1,2,3] [4,5,6,7] [8,9] // It should return [1,4,8,2,5,9,3,6,7].

    public class ZigzagIterator {

        private int idx = 0;
        private List<Iterator<Integer>> lst = new ArrayList<Iterator<Integer>>();
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
          lst.add(v1.iterator());
          lst.add(v2.iterator());
        }

        public int next() {
          while(!lst.get(idx).hasNext()){
            idx++; idx %= 2;
          }
          return lst.get(idx++).next();
        }

        public boolean hasNext() {
          return lst.get(0).hasNext() && lst.get(1).hasNext();
        }
    }

    /**
     * Your ZigzagIterator object will be instantiated and called as such:
     * ZigzagIterator i = new ZigzagIterator(v1, v2);
     * while (i.hasNext()) v[f()] = i.next();
     */
