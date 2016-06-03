// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
// For example, Given s = “eceba” and k = 2,
//
// T is "ece" which its length is 3.
public class Solution{
  // another idea is to count the number of chars. forward left pointer one by one, until some count reaches 0
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int len = s.length();
    if (len <= k) return len;
    int left = 0;
    int right = 0;
    int max = 0;
    Map<Character, Integer> map = new HashMap(); // map the last position of char c
    while(right < len){
      char cur = s.charAt(right);
      if (map.get(cur) != null){// map contains cur
          map.put(cur, right++);
      }
      else{ // map does not contains key
        if (map.size() < k){ // no sufficient diff keys
          map.put(cur, right++);
        }
        else {
          char leftBound = s.charAt(left);
          left = map.get(leftBound) + 1;
          map.remove(leftBound);
          map.put(cur, right++);
        }
      }
      max = Math.max(max, right - left);
    }
    return max;
  }
}
