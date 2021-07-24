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
反转链表，同剑指offer P24，自己实现。
从左向右依次修改指针的引用，从而反转链表。
*/

public class Solution {
	public ListNode ReverseList(ListNode head) {
		if(head == null) return null;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;
		while(next != null){
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;  //最后一次while循环后，链表末尾元素（即curr）的指针未修改，需额外修改一次。

		return curr;
	}
}
