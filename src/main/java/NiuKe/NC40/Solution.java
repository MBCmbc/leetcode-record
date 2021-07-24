package NiuKe.NC40;

import LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/*
同leetcode P445 Solution2,两数相加Ⅱ
*/
public class Solution {
	/**
	 *
	 * @param head1 ListNode类
	 * @param head2 ListNode类
	 * @return ListNode类
	 */
	public ListNode addInList (ListNode head1, ListNode head2) {
		// write code here
		Deque<Integer> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();
		while(head1 != null){
			stack1.push(head1.val);
			head1 = head1.next;
		}
		while(head2 != null){
			stack2.push(head2.val);
			head2 = head2.next;
		}

		int carry = 0;
		ListNode next = null;
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry!=0){
			int v1 = stack1.isEmpty() ? 0 : stack1.pop();
			int v2 = stack2.isEmpty() ? 0 : stack2.pop();
			int sum = v1 + v2 + carry;

			carry = sum / 10;
			ListNode curr = new ListNode(sum % 10);
			curr.next = next;
			next = curr;
		}

		return next;
	}
}
