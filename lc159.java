// Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
// For example, Given s = “eceba”,
//
// T is "ece" which its length is 3.
public class Solution{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
    int len = s.length();
		if (len <= 2) return len;
		int i = 0; int j = 0;
		int max = 2;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// last position to appear the char c
		for (int j = 0; j < len; j++){
			char c = s.charAt(j);
			if (map.size() < 2 || map.get(c) != null){
				max = Math.max(max, j - i + 1);
			}
			else // move i forward
			{
				int last = 0;
				for (char key : map.keySet())
					last = Math.max(last, map.get(key));
				i = last + 1;
			}
			map.put(c, j);
		}
		return max;
  }
}
