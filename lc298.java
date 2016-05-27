    // Given a binary tree, find the length of the longest consecutive sequence path.
    //
    // The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
    //
    // For example,
    //
    //    1
    //     \
    //      3
    //     / \
    //    2   4
    //         \
    //          5
    //
    // Longest consecutive sequence path is 3-4-5, so return 3.
    //
    //    2
    //     \
    //      3
    //     /
    //    2
    //   /
    //  1
    //
    // Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

    public class Solution {
        public int longestConsecutive(TreeNode root) {
          if (root == null) return 0;
          int left = longestConsecutive(root.left);
          int right = longestConsecutive(root.right);
          return Math.max(helper(root), Math.max(left, right));
        }

        private int helper(TreeNode root){//must start at root
          if (root == null) return 0;
          int res = 1;
          if (root.left != null && root.left.val == root.val + 1)
            res = Math.max(res, 1 + helper(root.left));
          if (root.right != null && root.right.val == root.val + 1)
            res = Math.max(res, 1 + helper(root.right));
          return res;
        }
      }
