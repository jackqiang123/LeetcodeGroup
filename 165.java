// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
// Here is an example of version numbers ordering:
//
// 0.1 < 1.1 < 1.2 < 13.37
// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    public int compareVersion(String version1, String version2) {
      String[]v1 = version1.split("\\.");
      String[]v2 = version2.split("\\.");
      int p1 = 0;
      int p2 = 0;
      while(p1 < v1.length && p2 < v2.length){
        int v1n = Integer.parseInt(v1[p1]);
        int v2n = Integer.parseInt(v2[p2]);
        if (v1n < v2n) return -1;
        else if (v1n > v2n) return 1;
        else {
          p1++; p2++;
        }
      }
      if (p1 == v1.length && p2 == v2.length) return 0;
      while (p1 < v1.length) {
          if (Integer.parseInt(v1[p1]) != 0) return 1;
          p1++;
      }
      while (p2 < v2.length) {
          if (Integer.parseInt(v2[p2]) != 0) return -1;
          p2++;
      }
      return 0;
    }
}
