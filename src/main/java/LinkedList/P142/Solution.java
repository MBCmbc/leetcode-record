package LinkedList.P142;

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
同剑指offer P23
https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
根据题解里的数学分析，若有环，快慢指针必定相遇，当找到快慢指针的相遇点后，fast从头出发，快慢指针同步通速向前，再次相遇点即为入口。

数学分析的关键点如下：
1.假设链表中非环部分的长度为a，环的长度为b，则第一次相遇时，就走过的节点数而言，有：
	fast = 2 * slow				//快指针速度是慢指针的两倍
	fast = slow + n * b			//快指针比慢指针多走了n个环
  可以推知：slow = n * b;
2.而链表上环入口的位置，必定是：a + n * b，所以想办法让slow再走a步就可以了。
3.所以把fast指针再置为head，快慢指针同步前进，会在环的入口再次相遇，因为此时二者都走了a步。

时间复杂度：O(N),第二次相遇中，慢指针须走步数a<a+b；第一次相遇中，慢指针须走步数a+b−x<a+b，其中x为双指针重合点与环入口距离；因此总体为线性复杂度；  打败100%
空间复杂度：O(1)        打败89.96%
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null) return null;
		ListNode slow = head, fast = head;
		do {
			if(fast==null || fast.next==null) return null;
			slow = slow.next;
			fast = fast.next.next;
		} while(slow != fast);

		fast = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}