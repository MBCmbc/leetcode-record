package LinkedList.P92;

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
刘启仁说这道题阿里笔试考了，我就来做做看。使用一遍扫描完成，一次for循环。
思路：在要反转的链表部分中，记第一个节点为m，最后一个节点为n。
    1. 标记好要反转的链表部分的前一个节点before
    2. 从第left位到第right位，迭代的进行反转
    3. 反转的最后一次，能得到“要反转的链表部分的后一个节点after”，而要反转的部分也反转完了。
    4. 把before的next指向n，m的next指向after，整个链表就反转完成了。
    5. 对于left=1的特殊情况，head==m，反转完之后m跑到后面去了，此时返回head是不行的，得返回n。
       故可以用一个自己创建的dummy节点，向head前延伸一下，代表before。
       而且这种做法对于普通情况下也是适用的，故统一用dummy代表head的前一个节点。最后返回dummy.next即可。

时间复杂度：O(N)，一次遍历。                               打败100%
空间复杂度：O(1)，几个额外的节点，占用常数空间。             打败98.2%
 */
class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);   //dummy节点，head前一个的虚拟节点
		dummy.next = head;
		ListNode m = dummy;
		for(int i = 0; i < left-1; i++) m = m.next;    //寻找反转链表部分的前一个节点，即befoer。
		ListNode before = m;
		m = m.next;
		ListNode prev = m;          //此时的m就代表需反转部分的第一个节点，从这里开始，进行反转。只在反转部分的内部进行反转，两侧的指针先不动。
		ListNode curr = m.next;


		for(int i = left; i < right; i++){  //迭代，反转。
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		//内部反转结束后，prev代表的就是需反转部分的最后一个节点，即n，则curr就是反转部分的后一个节点，即after。
		ListNode n = prev;
		ListNode after = curr;

		before.next = n;        //修改反转链表外侧两边的指针，连成新的链表即可。
		m.next = after;

		return dummy.next;      //返回头节点。
	}
}
