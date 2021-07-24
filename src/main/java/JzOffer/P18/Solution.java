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
时间复杂度：O(N)，寻找节点。                打败100%
空间复杂度：O(1)                           打败59.56%
 */
class Solution {
	public ListNode deleteNode(ListNode head, int val) {
		//val就是头节点
		if(head.val == val) {
			ListNode res = head.next;
			head.next = null;
			return res;
		}

		//val不是头结节点
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null && cur.val != val){
			pre = cur;
			cur = cur.next;
		}

		//链表中没有这个值
		if(cur == null) return head;

		//链表中有这个值
		pre.next = cur.next;
		cur.next = null;
		return head;
	}
}
