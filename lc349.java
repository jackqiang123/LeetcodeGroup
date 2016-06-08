// Given two arrays, write a function to compute their intersection.
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
// Note:
// Each element in the result must be unique.
// The result can be in any order.
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set = new HashSet();
      for (int n : nums1)
        set.add(n);
      List<Integer> res = new ArrayList();
      for (int n : nums2){
        if (set.contains(n))
        {
            res.add(n);
            set.remove(n);
        }
      }
      int [] list = new int[res.size()];
      int pos = 0;
      for (int i : res)
        list[pos++] = i;
      return list;
    }
}
