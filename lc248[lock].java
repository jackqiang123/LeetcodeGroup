// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
    public class Solution{
      public int strobogrammaticInRange(String low, String high){
        int count = 0;
        for (int len = low.length(); len <= high.length(); len++){
          List<String> resList = findStrobogrammatic(len);
          for (String s : resList){
            if (s.compareTo(low) != -1 && s.compareTo(high) != 1)
              count++;
          }
        }
        return count;
      }
      Map<Character, Character> map = new HashMap();
      map.put("0", "0");
      map.put("1", "1");
      map.put("8", "8");
      map.put("6", "9");
      map.put("9", "6");
      private List<String> findStrobogrammatic(int n){
        if (n == 0) return new ArrayList<String>().add("");
        if (n == 1) {
          List<String> res = new ArrayList();
          res.add("0");
          res.add("1");
          res.add("8");
          return res;
        }
        else{
          List<String> res = new ArrayList();
          List<String> innerList = findStrobogrammatic(n - 2);
          for (String cur : innerList){
            for (String c : map.keySet()){
              res.add(c + cur + map.get(c));
            }
          }
          return res;
        }
      }

      private boolean isStrobogrammatic(String n){
        Map<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int i = 0; int j = n.length() - 1;
        while(i <= j){
          char left = n.charAt(i);
          if (n.charAt(j) == map.get(left)){i++; j--;}
          else return false;
        }
        return true;
      }
    }
