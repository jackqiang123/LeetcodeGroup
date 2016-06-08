// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len = nums.length;
      k = Math.min(len, k);
      if (k <= 0 || len == 0) return new int[0];
      int []res = new int[len - k + 1];
      int index = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2){
          return i2-i1;
        }
      });
      int i = 0;
      while(index < res.length){
        while (pq.size() < k){
          pq.add(nums[i++]);
        }
        res[index++] = pq.peek();
        pq.remove(nums[i - k]);
        if (i < len)
          pq.add(nums[i++]);
      }
      return res;
    }
}
