package NiuKe.NC33;

import LinkedList.ListNode;/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/*
合并有序链表，同剑指offer P25。这里我采用的是迭代的遍历算法，不是递归。
依次遍历两个链表的各个节点，将val较小的节点接到curr上，知道某一个链表遍历完，把另一个链表的剩下部分接到curr上即可。

时间复杂度：O(M+N)，M和N为l1和l2的长度，需要遍历两个链表。
空间复杂度：O(1)。
 */
public class Solution {
	/**
	 *
	 * @param l1 ListNode类
	 * @param l2 ListNode类
	 * @return ListNode类
	 */
	public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
		// write code here
		if(l1 == null) return l2;		//针对l1或l2为空的特殊情况。
		if(l2 == null) return l1;

		ListNode head;					//先确定一下合并后链表的头。
		if(l1.val < l2.val){
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}

		ListNode curr = head;
		while(l1 != null && l2 != null){	//遍历两个链表，每次都选择val较小者，接到合并链表指针curr后面。
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}									//while跳出时，某个链表已经遍历完毕。

		curr.next = l1 != null ? l1 : l2;	//链表本身有序，把未遍历完的链表的剩余部分接上即可。
		return head;
	}
}
