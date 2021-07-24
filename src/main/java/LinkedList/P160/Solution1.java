package LinkedList.P160;

import LinkedList.ListNode;

import java.util.HashSet;

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
解法一，自己的思路。
先遍历一遍链表A，将所有节点都存储在一个HashSet中。然后遍历链表B，对每个元素都判断一下是否存在于前面构造的HashSet中，第一个存在的节点就是第一个公共节点。

时间复杂度：O(M+N)，M为链表A长度，N为链表B长度，两个链表各遍历了一遍。                      打败17.3%
空间复杂度：O(M)，HashSet存储了链表A的所有节点。                                            打败5.02%
*/

public class Solution1 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> setA = new HashSet<>();
		while(headA != null){
			setA.add(headA);
			headA = headA.next;
		}

		while(headB != null){
			if(setA.contains(headB)) return headB;
			headB = headB.next;
		}

		return null;    //遍历完链表B都没有返回，说明没有公共节点，返回Null。
	}
}
