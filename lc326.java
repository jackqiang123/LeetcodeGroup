// Given an integer, write a function to determine if it is a power of three.
//
// Follow up:
// Could you do it without using any loop / recursion?
public class Solution {
  public boolean isPowerOfThree(int n) {
      return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
  }
}
