package JzOffer.P22;

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
快慢指针解法，同剑指offer思路。
    一个快指针先走k步，然后慢指针从头开始，二者同步前进，当快指针到达链表末尾，慢指针所指节点即为所求。

为保证鲁棒性，请注意特殊情况：
    1.链表头节点为空
    2.k<=0;
    3.链表节点个数不足k

时间复杂度：O(N)，遍历链表，N为链表长度                 打败100%
空间复杂度：O(1)                                     打败79.77%
 */
class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		if(head==null || k<=0) return null;//链表头节点为空，返回null；k<=0，无意义，返回null。
		ListNode fastPointer = head; //快指针
		for(int i=1; i<=k-1; i++){//快指针先走k-1步
			fastPointer = fastPointer.next;
			if(fastPointer == null) return null;//若链表节点个数小于k，还未走完k-1步就会出现节点为空的情况，返回null。
		}

		ListNode slowPointer = head; //慢指针
		while(fastPointer.next != null){
			//快慢指针同步向后移动，保持位置差为k
			//当快指针到达链表结尾，慢指针所指即为所求。
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}

		return slowPointer;
	}
}
