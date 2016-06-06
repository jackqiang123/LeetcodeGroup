// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
// You may not alter the values in the nodes, only nodes itself may be changed.
//
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
//
// For k = 2, you should return: 2->1->4->3->5
//
// For k = 3, you should return: 3->2->1->4->5
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)  return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p1 = res;
        ListNode p2 = res;
        int count = k;
        while(p2 != null && p2.next != null){
          while(count > 0){
            count--;
            if (p2.next == null)  return res.next;
            else p2 = p2.next;
          }
          ListNode tail = p1.next;
          ListNode nexthead = p2.next;
          p2.next = null;
          p1.next = reverse(p1.next);
          tail.next = nexthead;
          p1 = tail;
          p2 = tail;
          count = k;
        }
        return res.next;
    }

    private ListNode reverse(ListNode head){
      ListNode res = new ListNode(0);
      while(head != null){
        ListNode p = head.next;
        head.next = res.next;
        res.next = head;
        head = p;
      }
      return res.next;
    }
}
