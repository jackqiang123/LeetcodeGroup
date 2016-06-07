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
      ListNode res = new ListNode(0);
      while(head != null){
        ListNode temp = head.next;
        head.next = null;
        ListNode p = res;
        while(p.next != null){
            if (p.next.val < head.val){
              p = p.next;
            }
            else {
              head.next = p.next;
              p.next = head;
              break;
            }
        }
        if (p.next == null){
          p.next = head;
        }
        head = temp;
      }
      return res.next;
    }
}
