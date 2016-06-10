// Given an array of n integers nums and a target, find the number of index triplets i, j,
// k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
// For example, given nums = [-2, 0, 1, 3], and target = 2.
// Return 2. Because there are two triplets which sums are less than 2:
// [-2, 0, 1]
// [-2, 0, 3]
// Follow up:
// Could you solve it in O(n^2) runtime?
public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length; i++){
      int base = target - nums[i];
      int p1 = i + 1;
      int p2 = nums.length - 1;
      while(p1 < p2){
        if (nums[p1] + nums[p2] >= base)
          p2--;
        else {
          res += (p2 - p1);
          p1++;
        }
      }
    }
    return res;
  }
}
