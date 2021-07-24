package LinkedList.P445;

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
同牛客网NC40,参考leetcode P02实现。分以下三步：
    1.将正序的两个链表反序
    2.利用leetcode P02的方法将两个反序的数字相加得到反序的结果。
    3.将反序结果再反转得到正序结果，返回。

时间复杂度：O(max(M,N))，三个步骤的时间复杂度都是O(max(M,N))。          打败88.19%
时间复杂度：O(max(M,N))，存储结果的新链表占用空间为O(max(M,N))。        打败94.09%
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode rev1 = reverse(l1);    //步骤1
		ListNode rev2 = reverse(l2);
		ListNode revRes = addList(rev1, rev2);  //步骤2
		return reverse(revRes);     //步骤3
	}

	public ListNode addList(ListNode l1, ListNode l2){  //将两个代表反序整数的链表相加，参考leetcode P02
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		int carry = 0;
		while(l1!=null || l2!=null){
			int v1 = l1==null ? 0 : l1.val;
			int v2 = l2==null ? 0 : l2.val;
			int sum = v1 + v2 + carry;

			p.next = new ListNode(sum % 10);
			carry = sum / 10;

			p = p.next;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}

		if(carry == 1) p.next = new ListNode(1);
		return dummy.next;
	}

	public ListNode reverse(ListNode head){     //反转链表
		if(head == null) return null;
		ListNode pre = null;
		ListNode curr = head;

		while(curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;
	}
}
