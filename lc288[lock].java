// An abbreviation of a word follows the form <first letter><number><last letter>.
// Below are some examples of word abbreviations:
//
// a) it                      --> it    (no abbreviation)
//
//      1
// b) d|o|g                   --> d1g
//
//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n
//
//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
//
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
// A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
// Example:
//
// Given dictionary = [ "deer", "door", "cake", "card" ]
//
// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true
public class ValidWordAbbr{
   HashMap<String, Set<String>> map;
   public ValidWordAbbr(String[] dictionary) {
     map = new HashMap();
     for (String s : dictionary){
        StringBuilder abbr = new StringBuilder();
        abbr.append(s.charAt(0)).append(s.length()).append(s.charAt(s.lenth() - 1));
        String key = abbr.toString();
        if (map.get(key) == null) map.put(key.toString(), new HashSet<String>());
        map.get(key).add(s);
     }
   }
   public boolean isUnique(String s) {
     StringBuilder abbr = new StringBuilder();
     abbr.append(s.charAt(0)).append(s.length()).append(s.charAt(s.lenth() - 1));
     String key = abbr.toString();
     if (map.get(key) == null) return true;
     else if (map.get(key).contains(s)) return map.get(key).size() <= 1;
     return true;

   }
 }
