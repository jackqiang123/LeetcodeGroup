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
