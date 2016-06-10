// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
//
// Example 1:
//      0          3
//      |          |
//      1 --- 2    4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
// Example 2:
//      0           4
//      |           |
//      1 --- 2 --- 3
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
//
// Note:
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

public class Solution {
  // can also be done in union find algorithm
      boolean visit[];
      Map<Integer,List<Integer>> map;
    public int countComponents(int n, int[][] edges) {
      visit[] = new int[n];
      map = new HashMap();
      for (int i = 0; i < edges.length; i++){
        int s = edges[i][0];
        int v = edges[i][1];
        if (map.get(s) == null) map.put(s, new ArrayList());
        if (map.get(v) == null) map.put(v, new ArrayList());
        map.get(s).add(v);
        map.get(v).add(s);
      }
      int res = 0;
      for (int i = 0; i < n; i++){
        if (!visit[i]){
          res++; dfs(i);
        }
      }
      return res;
    }
    private void dfs(int i){
      if (visit[i]) return;
      visit[i] = true;
      if (map.get(i) == null) return;
      for (int nb : map.get(i)){
        dfs(nb);
      }
    }
  }
