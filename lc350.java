// Given two arrays, write a function to compute their intersection.
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to num2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap();
      for (int n : nums1){
        if (map.get(n) == null) map.put(n,1);
        else map.put(n, map.get(n) + 1);
      }
      List<Integer> ls = new ArrayList<Integer>();
      for (int n : nums2){
        if (map.get(n) != null){
          ls.add(n);
          map.put(n, map.get(n)-1);
          if (map.get(n) == 0)
            map.remove(n);
        }
      }
      int [] res = new int[ls.size()];
      int pos = 0;
      for (int n : ls){
        res[pos++] = n;
      }
      return res;
    }
}
