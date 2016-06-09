// Given a nested list of integers, implement an iterator to flatten it.
//
// Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
// Example 1:
// Given the list [[1,1],2,[1,1]],
//
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//
// Example 2:
// Given the list [1,[4,[6]]],
//
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
     // a good idea will be just push the thing that we want to visit in reverse order
     Stack<NestedInteger> stack = new Stack<>();
     public NestedIterator(List<NestedInteger> nestedList) {
       stack = new Stack<NestedInteger>();
       for (int i = nestedList.size() - 1; i >= 0; i--){
         stack.push(nestedList.get(i));
       }
     }


     @Override
     public Integer next() {
       return stack.pop().getInteger();
     }

     @Override
     public boolean hasNext() {
       if (stack.isEmpty()) return false;
       NestedInteger cur = stack.peek();
       while(!cur.isInteger()){
         cur = stack.pop();
         for (int i = cur.getList().size() - 1; i >= 0; i--)
            stack.push(cur.getList().get(i));
         if (stack.isEmpty()) return false;
         cur = stack.peek();
       }
       return !stack.isEmpty() && stack.peek().isInteger();
     }
 }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


 // public class NestedIterator implements Iterator<Integer> {
 //
 //     Stack<Integer> index;
 //     Stack<NestedInteger> stack;
 //     List<NestedInteger> list;
 //     int mainPointer;
 //     public NestedIterator(List<NestedInteger> nestedList) {
 //       this.list = nestedList;
 //       stack = new Stack();
 //       index = new Stack();
 //       if (list.size() == 0) {mainPointer++; return;}
 //       NestedInteger cur = list.get(0);
 //       initStack(cur);
 //     }
 //
 //     private void initStack(NestedInteger cur){
 //       while(true){
 //         if (cur.isInteger()){
 //           stack.push(cur); break;
 //         }
 //         else {
 //             stack.push(cur);
 //           if (cur.getList().size() != 0){
 //             cur = cur.getList().get(0);
 //             index.push(0);
 //           }
 //           else {
 //              break;
 //           }
 //         }
 //       }
 //     }
 //
 //     @Override
 //     public Integer next() {
 //         NestedInteger cur = stack.pop(); // top of stack is always an integer
 //         Integer res = cur.getInteger();
 //
 //         while(!stack.isEmpty() && index.peek() == stack.peek().getList().size() - 1){
 //             stack.pop();
 //             index.pop();
 //         }
 //         if (stack.isEmpty()){
 //           mainPointer++;
 //           if (mainPointer != list.size()){
 //             initStack(list.get(mainPointer));
 //           }
 //           return res;
 //         }
 //         int curIndex = index.pop();
 //         curIndex++;
 //         index.push(curIndex);
 //         initStack(stack.peek().getList().get(curIndex));
 //         return res;
 //     }
 //
 //     @Override
 //     public boolean hasNext() {
 //       return mainPointer < list.size();
 //     }
 // }
