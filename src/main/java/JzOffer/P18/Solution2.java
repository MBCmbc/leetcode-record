package JzOffer.P18;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
用一个dummy节点的方式，解决要删除的节点是头结点的特殊情况。
 */
class Solution2 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, curr = head;
        while(curr != null && curr.val != val){
            curr = curr.next;
            pre = pre.next;
        }

        if(curr != null){
            pre.next = curr.next;
        }

        return dummy.next;
    }
}
