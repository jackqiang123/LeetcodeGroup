// Sort a linked list in O(n log n) time using constant space complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode median = findMedian(head);
      ListNode left = sortList(head);
      ListNode right = sortList(median);
      return mergeList(left, right);
    }
    private ListNode findMedian(ListNode head){
      ListNode p1 = new ListNode(0);
      p1.next = head;
      ListNode p2 = p1;
      while(p2.next != null && p2.next.next != null){
        p2 = p2.next.next;
        p1 = p1.next;
      }
      p2 = p1.next;
      p1.next = null;
      return p2;
    }
    private ListNode mergeList(ListNode p1, ListNode p2){
      ListNode dummy = new ListNode(0);
      ListNode res = dummy;
      while(p1!=null || p2!=null)
      {
        if (p1 != null && p2 != null)
        {
          if (p1.val < p2.val){
            dummy.next = p1;
            p1 = p1.next;
            dummy = dummy.next;
          }
          else {
            dummy.next = p2;
            p2 = p2.next;
            dummy = dummy.next;
          }
        }
        else if (p1 != null)
        {
          dummy.next = p1; break;
        }
        else {
          dummy.next = p2; break;
        }

      }
      return res.next;
    }
}
