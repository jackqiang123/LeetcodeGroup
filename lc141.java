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
      if (head == null) return false;
      ListNode p1 = head;
      ListNode p2 = head;
      while(p2 != null && p2.next != null && p2.next.next != null){
          p2 = p2.next.next;
          p1 = p1.next;
          if (p1 == p2) return true;
      }
      return false;
    }
}
