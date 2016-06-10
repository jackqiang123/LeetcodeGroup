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
			if (map.size() < 2){
				max = Math.max(j - i + 1, max);
				map.put(c, j);
			}
			else if (map.size() == 2){
				if (map.get(c) != null){
					max = Math.max(j - i + 1, max);
					map.put(c, j);
				}
				else { // i index must point to the positin to remove
					char firstChar = s.charAt(i);
					for (char key : map.keySet()){
						if (map.get(firstChar) > map.get(key))
							firstChar = key;
					}
					i = map.get(firstChar) + 1;
					map.remove(firstChar);
					map.put(c,j);
				}
			}
		}
		return max;
  }
}
