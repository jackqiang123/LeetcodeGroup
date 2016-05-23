// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.
//
// For example:
//
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
// Hint:
//
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
// Is this case a valid tree? Show More Hint Note: you can assume that no duplicate edges will appear in edges.
// Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class Solution {
    boolean[]visited;
    boolean[]onstack;
    Map<Integer, List<Integer>> adlist;
    public boolean validTree(int n, int[][] edges) {
      visited = new boolean[n];
      onstack = new boolean[n];
      adlist = new HashMap();
      for (int i = 0; i < edges.length; i++){
        int s = edges[i][0];
        int v = edges[i][1];
        if (adlist.get(s) == null){
          adlist.put(s, new ArrayList<Integer>());
        }
        adlist.get(s).add(v);
        if (adlist.get(v) == null){
          adlist.put(v, new ArrayList<Integer>());
        }
        adlist.get(v).add(s);
      }
        if (hasCycle(0, -1)) return false;
        for (boolean b : visited)
        {
          if (!b) return false;
        }
      return true;
    }

    private boolean hasCycle(int i, int sourceNode){
      if (visited[i]) return false;
      if (onstack[i]) return true;
      onstack[i] = true;
      List<Integer> nb = adlist.get(i);
      for (int n : nb){
        if (n == sourceNode) continue;
        if (hasCycle(n, i))
          return true;
      }
      onstack[i] = false;
      visited[i] = true;
      return false;
    }
  }
