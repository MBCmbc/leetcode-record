package LinkedList.P160;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*
同剑指offer P52
双指针法，参考大佬的题解和代码。
https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
两个指针node1和node2分别从headA和headB处出发，node1走到链表A末尾时，就置为headB；同理，node2走到链表B末尾时，就置为headA。
由于二者前进的速度时一样的，会同时遍历完链表A+链表B/链表B+链表A（M+N步），这时从后往前看，由于最后一部分是重合的，两个指针
必定会在第一个公共节点处相遇。所以说，第一个相同节点就是所求。

若两链表长度相等且相交，则第一轮就在首个公共节点处相遇并返回。

当两个链表不相交时，指针会同时停在链表B的末尾/链表A的末尾（同为null，判断为相等），从而返回null，符合题意。

时间复杂度：O(M+N)，M、N分别为两链表长度。最坏情况下不相交，每个指针都遍历了两个链表。（若相交，则相交部分不会遍历第二遍）         打败100%
空间复杂度：O(1)，未使用额外空间。                                                                                               打败15.8%
 */
public class Solution2 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode node1 = headA, node2 = headB;
		while(node1 != node2){
			node1 = node1 == null ? headB : node1.next;         //node1走到链表A末尾就转向headB
			node2 = node2 == null ? headA : node2.next;         //node2走到链表B末尾就转向headA
		}

		return node1;       //若相交，返回第一个公共节点；否则，返回null（最后两个指针都停在null处，判断为相等，跳出循环）。
	}
}
