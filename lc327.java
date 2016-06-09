// Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
// Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
//
// Note:
// A naive algorithm of O(n2) is trivial. You MUST do better than that.
//
// Example:
// Given nums = [-2, 5, -1], lower = -2, upper = 2,
// Return 3.
// The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
public class Solution {
int count;
 public int countRangeSum(int[] nums, int lower, int upper) {
   count = 0;
   long []sum = new long[nums.length];
   for (int i = 0; i < sum.length; i++)
   {
     sum[i] = nums[i] + (i-1>=0 ? sum[i-1] : 0);
     if(sum[i] <= upper && sum[i] >= lower)
       count++;
   }
   countByRange(sum, 0, sum.length - 1, lower, upper);
   return count;
 }

 private void countByRange(long []sum, int lo, int hi, int lower, int upper){
   if (lo >= hi) return;
   int mid = (lo + hi)/2;
   countByRange(sum, lo, mid, lower, upper);
   countByRange(sum, mid + 1, hi, lower, upper);
   //next we will need to do quick combine the sum
   long []temp = new long[hi - lo + 1];
   int pos = 0;
   int p1 = mid + 1; // the first elements that larger than sum[i] - lower
   int p2 = mid + 1; // the last elements that smaller than sum[i] - upper
   int i = lo;
   int j = mid + 1;
   while(i <= mid || j <= hi){
       if (i <= mid && j <= hi){
         if (sum[i] < sum[j]){
           //before we add i into the list, we should increase count
           p1 = Math.max(p1,leftBound(p1, lower + sum[i], sum, hi));
           p2 =  Math.max(p2, rightBound(p2, upper + sum[i], sum, hi));
           count += (p2 - p1);
           temp[pos++] = sum[i++];
         }
         else {
           temp[pos++] = sum[j++];
         }
       }
       else if (i <= mid){
         //before we add i into the list, we should increase count
         p1 = Math.max(p1,leftBound(p1, lower + sum[i], sum, hi));
         p2 = Math.max(p2,rightBound(p2, upper + sum[i], sum, hi));
         count += (p2 - p1);
         temp[pos++] = sum[i++];
       }
       else {
         temp[pos++] = sum[j++];
       }
   }
   for (i = 0; i < temp.length; i++){
     sum[i + lo] = temp[i];
   }
 }

 private int leftBound(int p1, long l, long[] sum, int end){
   while(p1 <= end && sum[p1] < l){
     p1++;
   }
   return p1;
 }

 private int rightBound(int p1, long l, long[] sum, int end){
   while(p1 <= end && sum[p1] <= l){
     p1++;
   }
   return p1;
 }
}
