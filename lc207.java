// There are a total of n courses you have to take, labeled from 0 to n - 1.
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
// For example:
//
// 2, [[1,0]]
//
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
// 2, [[1,0],[0,1]]
//
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
public class Solution {
    //for exercise purpose, we do a loop check for question, and do topologica sort for II version
    boolean[]visit;
    boolean[]onstack;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      visit = new boolean[numCourses];
      onstack = new boolean[numCourses];
      Map<Integer, List<Integer>> adjlist = new HashMap();
      for (int[]preq : prerequisites){
        int src = preq[1];
        int dst = preq[0];
        if (adjlist.get(src) == null) adjlist.put(src, new ArrayList<Integer>());
        adjlist.get(src).add(dst);
      }
      for (int i = 0; i < numCourses; i++){
        if (hasCycle(i, adjlist))
          return false;
      }
      return true;
    }

    private boolean hasCycle(int i, Map<Integer, List<Integer>> adjlist){
      if (onstack[i]) return true;
      if (visit[i]) return false;
      visit[i] = true;
      onstack[i] = true;
      List<Integer> nb = adjlist.get(i);
    if (nb != null) {
    for (int n : nb){
      if (hasCycle(n, adjlist)) return true;
    }
    }
      onstack[i] = false;
      return false;
    }
}
