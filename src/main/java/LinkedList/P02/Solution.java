package LinkedList.P02;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
思路：用一个新的链表记录相加所得的值，不必执着于在原有两个链表上改。

     对于这种要返回链表头的题目，可以用一个dummy节点作为链表头的前一个节点，最后返回dummy.next就可以了。

时间复杂度：O(max(M,N)),M和N为两个链表的长度。while循环次数为而这种较大者。         打败100%
空间复杂度：O(max(M,N))，记录结果的新链表长度为max(M,N)。                         打败31.99%
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
思路：用一个新的链表记录相加所得的值，不必执着于在原有两个链表上改。

     对于这种要返回链表头的题目，可以用一个dummy节点作为链表头的前一个节点，最后返回dummy.next就可以了。

时间复杂度：O(max(M,N)),M和N为两个链表的长度。while循环次数为而这种较大者。         打败100%
空间复杂度：O(max(M,N))，记录结果的新链表长度为max(M,N)。                         打败31.99%
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		int carry = 0;  //进位
		while(l1 != null || l2 != null || carry!=0){
			int v1 = l1==null ? 0 : l1.val;     //空节点视为0
			int v2 = l2==null ? 0 : l2.val;
			int sum = v1 + v2 + carry;          //加的时候不要忘了carry

			p.next = new ListNode(sum % 10);    //相加得到新的一位，以及进位。
			carry = sum / 10;

			p = p.next;                         //指针后移，进入下一循环。
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}

		//if(carry == 1) p.next = new ListNode(carry);        //结束时如果还有进位，需要一个新节点记录。

		return dummy.next;
	}
}
