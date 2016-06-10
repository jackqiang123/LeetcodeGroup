// There is a new alien language which uses the latin alphabet.
// However, the order among letters are unknown to you. You receive a list of words
// from the dictionary, wherewords are sorted lexicographically by the rules of this new language.
// Derive the order of letters in this language.
//
// For example,
// Given the following words in dictionary,
//
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".
//
// Note:
//
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.
public class Solution{
   Map<Character, List<Character>> order;// this order shall be obtained by compare two adjenct words
   // my inital idea is to compare all chars at the same time. which leads to very complexity codes
   // in fact, we can extract every pair of words.  this will be sufficient
   // the order is key is prev, list is next nodes
   public String alienOrder(List<String> words) {
     for (int i = 1; i < words.size(); i++)
     {
       String last = words.get(i-1);
       String cur = words.get(i);
       for (int j = 0; j < Math.min(last.length(), cur.length()); j++){
         if (last.charAt(j) != cur.charAt(j)){
           if (order.get(last.charAt(j)) == null) order.put(last, new ArrayList<Character>());
           if (!order.get(last.charAt(j)).contains(cur.charAt(j)))
            order.get(last.charAt(j)).add(cur.charAt(j));
           break;
         }
       }
       // in fact, we ignore the case of space. assume we know '' < all other char
     }
     return getOneOrder();
   }

   private String getOneOrder(){// topological sort to get the order
     Queue<Character> queue = new LinkedList<Character>();
     Map<Character, Integer> prevCount = new HashMap();
     for (char c : order.key()){
       for (char next : order.get(c)){
         int nextCount = 0;
         if (!prevCount.get(next) == null) nextCount = prevCount.get(next);
         prevCount.put(next, nextCount + 1);
       }
     }
     for (char c : order.keySet()){
       if (prevCount.get(c) == null){ // if it does not have any prevCount
         queue.add(c);
       }
     }
     StringBuilder res = new StringBuilder();
     while(!queue.isEmpty()){
       char cur = queue.remove();
       res.append(cur);
       for (int nb : order.get(cur)){
         if (prevCount.get(nb) == 1){
           prevCount.put(nb, 0);
           queue.add(nb);
         }
         else prevCount.put(nb, prevCount.get(nb) - 1);
       }
     }

     if (res.length() == order.keySet()) return res.toString();
     return "";
   }
