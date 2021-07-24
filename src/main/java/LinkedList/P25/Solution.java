package LinkedList.P25;

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
 参考大佬解法和代码实现。
 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 把链表分为已翻转部分，待翻转部分和未翻转部分。每次翻转一部分，指针指来指去的修改，具体可看大佬的步骤分解，很详细。

 时间复杂度：O(N),N为链表长度。进行了(N/K)次翻转，每次翻转为O(K)。              打败100%
 空间复杂度：O(1)                                                           打败66.41%
 */
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);   //head前面加一个dummy节点。
		dummy.next = head;
		ListNode pre = dummy;   //待翻转链表部分的前驱
		ListNode end = dummy;   //待翻转链表部分的最后一个节点

		while(pre.next != null){    //后面还有待翻转部分，才继续循环。
			for(int i=0; i<k && end!=null; i++) end = end.next;     //计数剩余节点是否够k个，不够k个则退出循环，停止翻转。
			if(end == null) break;
			ListNode start = pre.next;  //待翻转链表的部分的第一个节点
			ListNode next = end.next;   //记录未翻转部分的第一个节点，即下次要翻转的部分
			end.next = null;            //end后继节点置null，防止下面的翻转函数一次把整个链表全翻转了。
			pre.next = reverse(start);  //翻转这部分链表，返回翻转后链表的头节点（也就是原来的end节点），即pre的后继节点。

			pre = start;                //此时，start节点成为翻转后的尾节点,下次循环开始前，pre和end都要置于此处。
			end = start;
			pre.next = next;            //翻转完成后，和未翻转部分连接起来，以便下一次循环。
		}

		return dummy.next;      //翻转完成后，dummy.next即为新的头结点
	}

	//翻转链表的函数，返回翻转后的头结点。
	public ListNode reverse(ListNode head){
		ListNode pre = null;    //虚拟的pre节点，方便循环。
		ListNode curr = head;

		while(curr != null){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;     //返回翻转后链表的头节点，也即原链表的尾节点。
	}
}
