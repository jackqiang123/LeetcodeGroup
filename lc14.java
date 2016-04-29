// Write a function to find the longest common prefix string amongst an array of strings.
// using master theorem, T(n) = 2T(n/2) + constant - > T(n) = n
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return helper(strs, 0, strs.length - 1)
    }
    // we can increase the performance by passing the known prefix.
    // here , divide and conquer may not help since the complexity is linear to the problem scale
    private String helper(String[] strs, int lo, int hi){
        if (lo == hi) return strs[lo];
        int mid = (lo + hi)/2;
        String left = helper(strs, lo, mid);
        String right = helper(strs, mid + 1, hi);
        if (left.length() == 0 || right.length() == 0) return "";
        for (int i = 0; i < Math.min(left.length(), right.length()); i++)
        {
          if (left.charAt(i) != right.charAt(i)) return left.subString(0,i);
        }
        return left.subString(Math.min(left.length(), right.length()));
    }
}
