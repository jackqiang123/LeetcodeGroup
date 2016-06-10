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
    //using union find to get check whether there is loop or not
    public boolean validTree(int n, int[][] edges) {
      int[]nums = new int[n];
      for (int i = 0; i < n; i++)
        nums[i] = i;
      for (int[]edge : edgs){
          int x = root(nums, edge[0]);
          int y = root(nums, edge[1]);
          if (x == y) return false;
          nums[x] = y;
      }
      return edges.length == n - 1;// if all connect without loop, there is exact n-1 links
    }
    private int root(int[]nums, int i){
      if (nums[i] == i) return i;
      return root(nums, nums[i]);
    }
  }
