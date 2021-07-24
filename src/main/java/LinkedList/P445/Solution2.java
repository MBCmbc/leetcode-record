package LinkedList.P445;

import LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
不反转链表的实现方法，用栈。题目所给链表是从高位到低位的，无法按顺序计算。先把元素按链表顺序入栈，再依次出栈进行计算，就可以达到从低位开始计算的效果。
https://leetcode-cn.com/problems/add-two-numbers-ii/solution/liang-shu-xiang-jia-ii-by-leetcode-solution/

最后出栈计算，生成链表的时候，是从后向前依次生成的：
    1. 上一步先得到next，
    2. 在本步得到curr，并将curr.next指向next
    3. 将curr赋值给next，成为下一步循环的next节点。
    4. 不停循环得到完整链表。
这是以前没见过的，可以关注一下。

时间复杂度：O(max(M,N))，M和N分别是两个链表的长度。while循环需要执行这么多步。              打败78.38%
空间复杂度：O(M+N)，两个栈的大小。                                                      打败56.21%
 */
class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new ArrayDeque<>(); //两个操作数栈
		Deque<Integer> stack2 = new ArrayDeque<>();

		while(l1 != null){
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while(l2 != null){
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode next = null;    //对每一次循环来说，next代表的是curr节点的后一个节点。
		int carry = 0;           //第一次循环时，curr是结果的最后一个节点，对应next就应该是null。
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry!=0){
			int v1 = stack1.isEmpty() ? 0 : stack1.pop();
			int v2 = stack2.isEmpty() ? 0 : stack2.pop();
			int sum = v1 + v2 + carry;

			carry = sum / 10;   //计算下一次进位
			ListNode curr = new ListNode(sum % 10); //计算当前位
			curr.next = next;   //进行连接
			next = curr;
		}

		//循环结束后，next指向的就是结果链表的头结点。
		return next;
	}
}
