// You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
//
// Example:
//
// Given nums = [5, 2, 6, 1]
//
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
//
// Return the array [2, 1, 1, 0].
public class Solution {
    class Number{
      int val;
      int index;
      int count;
      public Number(int val, int index, int count){
        this.val = val;
        this.index = index;
        this.count = count;
      }
    }
    public List<Integer> countSmaller(int[] nums) {
       Number[] num = new Number[nums.length];
       for (int i = 0; i < nums.length; i++){
         num[i] = new Number(nums[i], i, 0);
       }
       findInversion(num, 0, num.length - 1);
       Arrays.sort(num, new Comparator<Number>(){
         public int compare(Number n1, Number n2){
           return n1.index - n2.index;
         }
       });
       List<Integer> res = new ArrayList();
       for (Number n : num){
         res.add(n.count);
       }
       return res;
    }
    private void findInversion(Number[] num, int start, int end){
      if (start >= end) return;
      int mid = (start + end)/2;
      findInversion(num, start, mid);
      findInversion(num, mid + 1, end);
      quickCombine(num, start, mid, end);
    }
    private void quickCombine(Number[]num, int start, int mid, int end){
      int i = start;
      int j = mid + 1;
      int pos = 0;
      Number[]temp = new Number[end - start + 1];
      int rightCount = 0;
      while(i <= mid || j <= end){
        if (i <= mid && j <= end){
          if (num[i].val > num[j].val){
            rightCount++;
            temp[pos++] = num[j++];
          }
          else {
            num[i].count += rightCount;
            temp[pos++] = num[i++];}
        }
        else if (i <= mid){
          num[i].count += rightCount;
          temp[pos++] = num[i++];
        }
        else {
          temp[pos++] = num[j++];
        }
      }
      for (i = start; i <= end; i++){
        num[i] = temp[i-start];
      }
    }

}
