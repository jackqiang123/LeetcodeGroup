// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
//
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
public class Solution {
    public String minWindow(String s, String t) {
      Map<Character, Integer> tmap = new HashMap();
      Map<Character, Integer> smap = new HashMap();
      int tlen = t.length(); int slen = s.length();
      if (tlen == 0) return "";
      for (int i = 0; i < tlen; i++){
        char c = t.charAt(i);
        smap.put(c,0);
        if (tmap.get(c) == null) tmap.put(c,1);
        else tmap.put(c, tmap.get(c) + 1);
      }
      int i = 0; int j = 0; int curlen = 0;
      int besti = 0; int bestj = 0; int bestlength = Integer.MAX_VALUE;
      while(j < slen){
        char c = s.charAt(j);
        if (tmap.get(c) == null){
          j++;
        }
        else if (smap.get(c) >= tmap.get(c)){
          j++; smap.put(c, smap.get(c) + 1);
        }
        else {
            smap.put(c, smap.get(c) + 1);
            curlen++;
            while(curlen == tlen){
              int curres = j - i + 1;
              if (bestlength > curres){
                bestlength = curres;
                besti = i;
                bestj = j;
              }
              char lastc = s.charAt(i);
              if (smap.get(lastc) != null){
                smap.put(lastc, smap.get(lastc) - 1);
                if (smap.get(lastc) < tmap.get(lastc))
                  curlen--;
              }
              i++;
            }
            j++;
        }
      }
      return bestlength == Integer.MAX_VALUE ? "" : s.substring(besti, bestj+1);
    }
}
