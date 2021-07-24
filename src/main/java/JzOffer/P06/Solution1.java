package JzOffer.P06;

import LinkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*
剑指Offer思路一，用栈。
    因为要反向输出节点值，正好复合栈“先进后出”的特点，于是在遍历链表的时候用一个栈先存储各个节点的值，然后再依次取出栈中的值，放到结果数组。

时间复杂度：O(N)，两次循环                          打败73.35%
空间复杂度：O(N)，额外开辟了一个栈空间               打败81.5%
 */
class Solution1 {
	public int[] reversePrint(ListNode head) {
		Deque<Integer> stack = new LinkedList<>();
		ListNode curr = head;
		while(curr != null){
			stack.push(curr.val);
			curr = curr.next;
		}

		int len = stack.size();
		int[] res = new int[len];
		for(int i = 0 ; i < len; i++){
			res[i] = stack.pop();
		}

		return res;
	}
}
