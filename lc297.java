// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// For example, you may serialize the following tree
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder res = new StringBuilder();
      Queue<TreeNode> queue = new LinkedList();
      if (root == null) {res.append("#");return res.toString();}
      queue.add(root);res.append(root.val).append(',');
      while(!queue.isEmpty()){
        TreeNode cur = queue.remove();
          if (cur.left != null){
            queue.add(cur.left);
            res.append(cur.left.val).append(',');
          }
          else{
            res.append('#').append(',');
          }
          if(cur.right != null) {
            queue.add(cur.right);
            res.append(cur.right.val).append(',');
          }
          else{
            res.append('#').append(',');
          }
      }
      res.deleteCharAt(res.length() - 1);
      return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String treedata) {
      if (treedata == null || treedata.length() == 0) return null;
      String [] data = treedata.split(",");
      if (data[0].equals("#")) return null;
      TreeNode root = new TreeNode(Integer.parseInt(data[0]));
      Queue<TreeNode> queue = new LinkedList();
      queue.add(root);
      int index = 1;
      while(queue.isEmpty() == false && index < data.length){
        TreeNode cur = queue.remove();
        String left = data[index++];
        String right = data[index++];

        if (left.equals("#")){
          cur.left = null;
        }
        else {
          cur.left = new TreeNode(Integer.parseInt(left));
          queue.add(cur.left);
        }

        if (right.equals("#")){
          cur.right = null;
        }
        else {
          cur.right = new TreeNode(Integer.parseInt(right));
            queue.add(cur.right);
        }
      }
      return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
