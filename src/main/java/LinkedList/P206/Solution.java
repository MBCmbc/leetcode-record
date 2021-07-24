package LinkedList.P206;

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
题解方法一，迭代
https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
用三个指针分别记录prev、curr、next三个节点，从头到尾遍历，反转链表。

时间复杂度：O(N)            打败100%
空间复杂度：O(1)            打败86.84%
 */
class Solution {
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next;

		while(curr != null){
			//把next的更新放在循环体开始而不是最后，避免curr为null时出现空指针异常
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		//画一下便知，循环结束后，prev所指即为新链表头，也即原链表尾
		return prev;
	}
}
