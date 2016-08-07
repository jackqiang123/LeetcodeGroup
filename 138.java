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
    public RandomListNode copyRandomList(RandomListNode head) {
      copyList(head);
      RandomListNode dummy = new RandomListNode(0);
      RandomListNode res = dummy;
      while(head != null){
        dummy.next = head.next;
        head.next = head.next.next;
        head = head.next;
        dummy = dummy.next;
      }
      return res.next;
    }
    private void copyList(RandomListNode head){
      RandomListNode dummy = head;
      while(head != null){
        RandomListNode temp = head.next;
        RandomListNode newNode = new RandomListNode(head.label);
        head.next = newNode;
        newNode.next = temp;
        head = temp;
      }
      head = dummy;
      while(head != null){
        RandomListNode thisRandom = head.random;
        if (thisRandom != null) {
          head.next.random = thisRandom.next;
        }
        head = head.next.next;
      }
    }
}
