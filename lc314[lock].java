// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
// If two nodes are in the same row and column, the order should be from left to right.
//
// Examples:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
//
//
//
// Given binary tree [3,9,20,4,5,2,7],
//
//     _3_
//    /   \
//   9    20
//  / \   / \
// 4   5 2   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [4],
//   [9],
//   [3,5,2],
//   [20],
//   [7]
// ]
public class Solution{
    class PositionTreeNode{
      TreeNode node;
      int col; // location of this node
      public PositionTreeNode(TreeNode node, int col){
        this.node = node;
        this.col = col;
      }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList();
      if (root == null) return res;
      Queue<PositionTreeNode> queue = new LinkedList();
      Map<Integer, List<Integer>> map = new HashMap();
      queue.add(new PositionTreeNode(root, 0));
      queue.add(null);
      while(!queue.isEmpty()){
        PositionTreeNode cur = queue.remove();
        if (cur != null){
          int col = cur.col;
          TreeNode curNode = cur.node;
          if (map.get(col) == null) map.put(col, new ArrayList<Integer>());
          map.get(col).add(curNode.val);
          if (curNode.left != null){
            queue.add(new PositionTreeNode(curNode.left, cur.col - 1));
          }
          if (curNode.right != null){
            queue.add(new PositionTreeNode(curNode.right, cur.col + 1));
          }
        }
        else {
          if (!queue.isEmpty())
            queue.add(null);
        }
      }
      for (int col : map.keySet()){
        res.add(map.get(col));
      }
      Collestion.sort(res, new Comparator<List<Integer>>(){
        public int compare(List<Integer> i1, List<Integer> i2){
          return i1.get(0).col - i2.get(0).col;
        }
      });
      return res;
    }
  }
