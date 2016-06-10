// Implement an iterator to flatten a 2d vector.
//
// For example, Given 2d vector =
//
// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
public class Solution{
  int i = 0;
  int j = 0;
  List<List<Integer>> vec2d;
  public Vector2D(List<List<Integer>> vec2d) {
    i = 0;
    j = 0;
    this.vec2d = vec2d;
  }
  public int next(){
    int res = vec2d.get(i).get(j);
    j++;
    if (j == vec2d.get(i).size()){
      i++; j = 0；
    }
    return res;
  }
  public boolean hasNext(){
    return i < vec2d.size();
  }
}
