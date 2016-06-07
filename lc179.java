// Given a list of non negative integers, arrange them such that they form the largest number.
//
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
// Note: The result may be very large, so you need to return a string instead of an integer.
public class Solution {
    public String largestNumber(int[] num) {
        String nums[] = new String[num.length];
        for (int i = 0; i < num.length; i++){
            nums[i] = String.valueOf(num[i]);
        }
      Arrays.sort(nums, new Comparator<String>(){
        public int compare(String s1, String s2){
          String n1 = s1 + s2;
          String n2 = s2 + s1;
          return n2.compareTo(n1);
        }
      });
      StringBuilder res = new StringBuilder();
      for (String n : nums)
        res.append(n);
      if (res.charAt(0) == '0') return "0";
      return res.toString();
    }
}
