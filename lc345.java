// Write a function that takes a string as input and reverse only the vowels of a string.
//
// Example 1:
// Given s = "hello", return "holle".
//
// Example 2:
// Given s = "leetcode", return "leotcede".
public class Solution {
    public String reverseVowels(String s) {
      if (s == null || s.length() == 0) return s;
      char []array = s.toCharArray();
      int i = 0;
      int j = s.length() - 1;
      Set<Character> set = new HashSet();
      set.add('a');      set.add('e');      set.add('i');      set.add('o');      set.add('u');
      set.add('A');      set.add('E');      set.add('I');      set.add('O');      set.add('U');
      while(i < j){
        while(i < j && !set.contains(s.charAt(i))) i++;
        while(i < j && !set.contains(s.charAt(j))) j--;
        if (i < j) swap(array, i++, j--);
      }
      return new String(array);
    }
    private void swap(char[]array, int i, int j){
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
