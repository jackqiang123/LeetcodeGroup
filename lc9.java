//Determine whether an integer is a palindrome. Do this without extra space.
public class Solution {
    public boolean isPalindrome(int x) {
       if (x == Integer.MIN_VALUE) return false;
       if (x < 0) return false;
       int res = x;
       int rev = 0;
       while(res != 0){
         int bit = res%10;
         if (rev > (Integer.MAX_VALUE - bit)/10) return false;
         rev = rev * 10 + bit;
         res = res/10;
       }
       return rev == x;
    }
}
