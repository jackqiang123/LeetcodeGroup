// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
// Return a deep copy of the list.
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private Map<RandomListNode, RandomListNode> map;
    public RandomListNode copyRandomList(RandomListNode head) {
      map = new HashMap<RandomListNode, RandomListNode>();
      return helper(head);
    }
    private RandomListNode helper(RandomListNode head){
      if (head == null) return null;
      if (map.get(head) != null) return map.get(head);
      RandomListNode newHead = new RandomListNode(head.label);
      map.put(head, newHead);
      newHead.next = helper(head.next);
      newHead.random = helper(head.random);
      return newHead;
    }
}
