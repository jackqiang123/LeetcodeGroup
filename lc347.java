// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
public class Solution {
    class Cell{
      int val;
      int count;
      public Cell(int val, int count){
        this.val = val;
        this.count = count;
      }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap();
      for (int n : nums){
        if (map.get(n) == null) map.put(n,1);
        else map.put(n, map.get(n) + 1);
      }
      List<Cell> data = new ArrayList();
      for (int key : map.keySet()){
        data.add(new Cell(key, map.get(key)));
      }
      PriorityQueue<Cell> pq = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
        public int compare(Cell c1, Cell c2){
          return c1.count - c2.count;
        }
      });
      for (Cell c : data){
        if (pq.size() < k) pq.add(c);
        else {
          pq.add(c);
          pq.remove();
        }
      }
      List<Integer> res = new ArrayList();
      while(!pq.isEmpty()){
        res.add(pq.remove().val);
      }
      return res;
    }
}
