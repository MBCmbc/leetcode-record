package NiuKe.NC53;

import LinkedList.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/*
同剑指offer P22，只不过这里要删除该节点，而不仅仅是返回。
思路：
    一个快指针先走n步，然后快慢指针同步走，直到快指针为null，慢指针就是倒数第N+1个节点，删除倒数第N个即可。
    用了一个dummy节点，应对倒数第n个就是头结点的情况。
*/
public class Solution {
	/**
	 *
	 * @param head ListNode类
	 * @param n int整型
	 * @return ListNode类
	 */
	public ListNode removeNthFromEnd (ListNode head, int n) {
		// write code here
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = head;

		for(int i = 0; i < n; i++) fast = fast.next;

		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;    //删除倒数第n个节点
		return dummy.next;
	}
}
