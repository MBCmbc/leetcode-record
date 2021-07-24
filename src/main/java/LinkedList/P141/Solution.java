package LinkedList.P141;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*
官方题解，方法二，快慢指针。
https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
快指针每次走两步，慢指针每次走一步，若链表有环，则快慢指针必定会在链表上某点相遇。

时间复杂度：O(N)，即使有环，入环之后，快慢指针间的距离每次减一（可看作慢指针在前，快指针在后，快指针追赶慢指针），故至多移动N轮         打败100%
空间复杂度：O(1)                                                                                                            打败77.83%
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		if(head==null || head.next==null) return false;
		ListNode slow = head, fast = head;
		do {
			//因为fast比较快，链表无环的情况下一定是fast先到末尾，故无需判断slow是否为null。
			//因为涉及到fast.next.next的访问，所以fast.next是否为null也要提前判断，避免空指针异常。
			if(fast==null || fast.next==null) return false;
			slow = slow.next;
			fast = fast.next.next;
		} while(slow != fast);

		return true;
	}
}
