// Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        while(l1 != null || l2 != null){
          if (l1 != null && l2 != null){
            if (l1.val < l2.val){
              p.next = l1; p = p.next; l1 = l1.next;
            }
            else {
              p.next = l2; p = p.next; l2 = l2.next;
            }
          }
          else if (l1 != null){
              p.next = l1; break;
          }
          else {
              p.next = l2; break;
          }
        }
        return res.next;
    }
}
