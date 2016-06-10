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
    int j = 0;
    int max = 0;
    Map<Character, Integer> map = new HashMap(); // map the char to count.
    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(map.size() < k){
        if(map.get(c) == null) map.put(c,1);
        else map.put(c,map.get(c)+1);
      }
      else if (map.get(c) != null){ //map.size() == k
        map.put(c, map.get(c)+1);
      }
      else { // map.size() == k and c is a new char
        while(true){
          if (map.get(s.charAt(j)) == 1){
            map.remove(s.charAt(j++));
            break;
          }
          else {
            map.put(s.charAt(j), map.get(j) - 1);
            j++;
          }
        }
      }
      max = Math.max(max, i - j + 1);
    }
    return max;
  }
}
