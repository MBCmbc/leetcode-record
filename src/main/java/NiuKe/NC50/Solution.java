package NiuKe.NC50;

import LinkedList.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/*
同leetcode P25      k个一组翻转链表
*/
public class Solution {
	/**
	 *
	 * @param head ListNode类
	 * @param k int整型
	 * @return ListNode类
	 */
	public ListNode reverseKGroup (ListNode head, int k) {
		// write code here
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode end = dummy;
		ListNode start = dummy;

		while(pre.next != null){
			for(int i = 0; i<k && end!=null; i++) end = end.next;
			if(end == null) break;
			start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);

			pre = start;
			end = start;
			start.next = next;
		}

		return dummy.next;
	}

	ListNode reverse(ListNode head){
		ListNode pre = null;
		ListNode curr = head;

		while(curr != null){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;
	}
}
