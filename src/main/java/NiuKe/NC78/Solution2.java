package NiuKe.NC78;

import LinkedList.ListNode;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
翻转链表，做法2，和剑指offer的做法一样。用一个dummy的节点作首个pre进行循环，代码更简洁。
 */
public class Solution2 {
	public ListNode ReverseList(ListNode head) {
		if(head == null) return null;

		ListNode pre = null;
		ListNode curr = head;

		while(curr != null){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;
	}
}
