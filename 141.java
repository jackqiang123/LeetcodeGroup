// Given a linked list, determine if it has a cycle in it.
//
// Follow up:
// Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
      ListNode p1 = new ListNode(0);
      p1.next = head;
      ListNode p2 = p1;
      while(p1 != null && p1.next != null){
        p1 = p1.next.next;
        p2 = p2.next;
        if (p1 == p2) return true;
      }
      return false;
    }
}
