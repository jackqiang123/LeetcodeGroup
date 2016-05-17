// Sort a linked list using insertion sort.
//
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode res = dummy;
      while(head != null){
        ListNode p = dummy;
        while(p.next.val < head.val){
          p = p.next;
        }
        ListNode temp = head.next;
        if (p.next != head)
        {
            ListNode tail = p;
            while(tail.next != head)
              tail = tail.next;
            tail.next = null;
            head.next = p.next;
        }
        else
          head.next = null;
        p.next = head;
        head = temp;
      }
      return res.next;
    }
}
