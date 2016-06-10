// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
// You may assume each number in the sequence is unique.
//
// Follow up: Could you do it using only constant space complexity?
public class Solution {

    // nlogn algrithm
    public boolean verifyPreorder(int[] preorder) {
      return helper(preorder, 0, preorder.length - 1);
    }
    private boolean helper(int []nums, int start, int end){
      if (start >= end) return true;
      int rootVal = nums[start];
      int rightIndex = start;
      while(rightIndex <= end){
        if (nums[rightIndex] < rootVal)
          rightIndex++;
      }
      for (int j = rightIndex; j <= end; j++){
        if (nums[j] < rootVal)
          return false;
      }
      return helper(nums, start + 1, rightIndex - 1) && helper(nums, rightIndex, end);
    }

    // linear algorithm simulate preorder trasvarl
    public boolean verifyPreorderUsingStack(int []preorder){
      Stack<Integer> stack = new Stack();
      int low = Integer.MIN_VALUE;
      for (int i : preorder){
        if (!stack.isEmpty() && i < low)
          return false;
        while(!stack.isEmpty() && stack.peek() < i){
          low = stack.pop();
        }
        stack.push(i);
      }
      return true;
    }
  }
