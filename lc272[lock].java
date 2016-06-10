// Problem Description:
//
// Given a non-empty binary search tree and a target value,
// find k values in the BST that are closest to the target.
//
// Note:
//
//     Given target value is a floating point.
//     You may assume k is always valid, that is: k ≤ total nodes.
//     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
// Hint:
//
//     Consider implement these two helper functions:
//         getPredecessor(N), which returns the next smaller node to N.
//         getSuccessor(N), which returns the next larger node to N.
//     Try to assume that each node has a parent pointer, it makes the problem much easier.
//     Without parent pointer we just need to keep track of the path from the root to the current
//     node using a stack.
//     You would need two stacks to track the path in finding predecessor and successor node separately.
public class Solution{
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      List<Integer> res = new ArrayList();
      Stack<TreeNode> prevStack = new Stack();
      Stack<TreeNode> succStack = new Stack();
      while(root!=null){ // this init stack is most critical
        if (target <= root.val){
          succStack.push(root); // the idea is every time we meet a larger element, it is a successor.
          // and the more near root, the more near to root in inorder seq
          root = root.left;
        }
        else {
          prevStack.push(root);
          root = root.right;
        }
      }
      while(k-- > 0){
        if (prevStack.isEmpty()){
          res.add(getSuccessor(succStack));
        }
        else if (succStack.isEmpty()){
          res.add(getPredecessor(prevStack));
        }
        else if (Math.abs(target - prevStack.peek(prevStack)) < Math.abs(target - succStack.peek(succStack)))
          res.add(getPredecessor(prevStack));
        else res.add(getSuccessor(succStack));
      }
      return res;
    }

    private int getSuccessor(Stack<TreeNode> stack){
      TreeNode res = stack.pop();
      int r = res.val;
      res = res.right;
      while(res != null){
        stack.push(res);
        res = res.left;
      }
      return r;
    }

    private int getPredecessor(Stack<TreeNode> stack){
      TreeNode res = stack.pop();
      int r= res.val;
      res = res.left;
      while(res != null){
        stack.push(res);
        res = res.right;
      }
      return r;
    }
  }
