package LinkedList.P148;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
官方题解，方法一，自顶向下归并排序。

时间复杂度：O(NlogN)，N为链表长。                       打败78.65%
空间复杂度：O(logN)，递归调用栈的空间。                 打败38.69%
 */
class Solution {
	public ListNode sortList(ListNode head) {
		return sort(head, null);
	}

	private ListNode sort(ListNode head, ListNode tail){
		if(head == null) return null;
		if(head.next == tail){      //tag1，把链表拆成一个一个的节点。
			head.next = null;
			return head;
		}

		ListNode slow = head, fast = head;      //寻找当前部分链表的中间节点mid
		while(fast != tail){
			slow = slow.next;
			fast = fast.next;
			if(fast != tail) fast = fast.next;
		}   //while循环结束后，fast指向tail节点，slow指向mid节点
		ListNode mid = slow;

		ListNode l1 = sort(head, mid);  //拆分时，左右两边重叠了一个mid节点，是为了和tag1对应，把链表拆成一个一个的节点。
		ListNode l2 = sort(mid, tail);  //以便再向上返回的时候，两两合并形成新的链表
		ListNode sorted = merge(l1, l2);
		return sorted;
	}

	private ListNode merge(ListNode list1, ListNode list2){ //合并两个排序链表
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		ListNode p1 = list1, p2 = list2;

		while(p1 != null && p2 != null){
			if(p1.val < p2.val){
				res.next = p1;
				p1 = p1.next;
			} else{
				res.next = p2;
				p2 = p2.next;
			}
			res = res.next;
		}

		if(p1 != null) res.next = p1;
		if(p2 != null) res.next = p2;

		return dummy.next;
	}
}
