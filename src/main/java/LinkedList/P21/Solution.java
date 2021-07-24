package LinkedList.P21;

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
递归题解，实现代码
https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/

终止条件：l1或l2为空时结束
返回值：每层调用都返回合并好的链表

时间复杂度：O(M+N)，M为了l1长度，N为l2长度                  打败
空间复杂度：O(M+N)，递归调用栈深度                          打败
*/
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		//若l1更小，则确定l1为这一层的头，l1.next与l2合并，返回结果作为l1新的后继
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{     //l2同理
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
