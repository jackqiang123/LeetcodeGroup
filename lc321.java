// Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
//
// Example 1:
//
// nums1 = [3, 4, 6, 5]
// nums2 = [9, 1, 2, 5, 8, 3]
// k = 5
// return [9, 8, 6, 5, 3]
//
// Example 2:
//
// nums1 = [6, 7]
// nums2 = [6, 0, 4]
// k = 5
// return [6, 7, 6, 0, 4]
//
// Example 3:
//
// nums1 = [3, 9]
// nums2 = [8, 9]
// k = 3
// return [9, 8, 9]
public class Solution {
		  public int[] maxNumber(int[] nums1, int[] nums2, int k){
			    int res[] = new int[k];
			    for (int leftCount = Math.max(0, k - nums2.length); leftCount <= Math.min(k, nums1.length); leftCount++){

			      int []cur = merge(getMax(nums1, leftCount), getMax(nums2, k - leftCount), k);
			      if (isBetter(cur, 0, res, 0)) res = cur;
			    }
			    return res;
			  }
			  private int[]getMax(int []num, int len){
			    int res[] = new int[len];
			    if (len == 0) return res;
			    int j = 0;
			    int lastPos = 0;
			    for (int i = 0; i < len; i++){
			    	j = lastPos;
			      while(num.length  - j >= len - i ){
			        if (num[j] > res[i]){
			          res[i] = num[j];
			          lastPos = j + 1;
			        }
			        j++;
			      }
			    }
			    return res;
			  }

			  private int[] merge(int []left, int []right, int k){
			    if (left.length == 0) return right;
			    if (right.length == 0) return left;
			    int res[] = new int[k];
			    int i = 0; int j = 0;
			    int pos = 0;
			    while(i < left.length || j < right.length){
			           if (isBetter(left, i, right, j)) res[pos++] = left[i++];
                 else res[pos++] = right[j++];
			    }
			    return res;
			  }

			  private boolean isBetter(int []cur, int i, int []last, int j){
          while(i < cur.length && j < last.length){
            if (cur[i] == last[j]) {
              i++; j++;
            }
            else if (cur[i] > last[j]) return true;
            else return false;
          }
          return j == last.length;
			  }
		   }
