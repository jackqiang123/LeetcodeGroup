import java.lang.Math;

public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        } else if (num % 10 != 4 && num % 10 != 6 && num != 1) {
            return false;
        } else {
            return Math.pow(2,30) % num == 0;
        }
    }
}