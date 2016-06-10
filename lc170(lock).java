// Design and implement a TwoSum class. It should support the following operations: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
// For example,
//
// add(1);
// add(3);
// add(5);
// find(4) -> true
// find(7) -> false
public class TwoSum {
  Map<Integer, Integer> map;
  public TwoSum(){
    map = new HashMap<Integer, Integer>();
  }
  public void add(int x){
    map.put(x, map.get(x) == null ? 1 : map.get(x) + 1);
  }
  public boolean find(int value){
    for (int x : map.keySet()){
      if (map.get(value - x) != null){
        if (value - x == x){
          if (map.get(x) >= 2)
            return true;
        }
        else return true;
      }
    }
    return false;
  }
}
