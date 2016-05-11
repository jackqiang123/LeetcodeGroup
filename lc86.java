// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
      ListNode left = new ListNode(0);
      ListNode right = new ListNode(0);
      ListNode p1 = left;
      ListNode p2 = right;
      while(head != null){
        if (head.val < x){
          p1.next = head;
          p1 = p1.next;
        }
        else {
          p2.next = head;
          p2 = p2.next;
        }
        head = head.next;
      }
      p2.next = null;// mark the right to be the tail
      p1.next = right.next;
      return left.next;
    }
}
