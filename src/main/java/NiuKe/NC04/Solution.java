package NiuKe.NC04;

import LinkedList.ListNode;
/*
环形链表问题，同Leetcode P141。
使用两个指针，一快（一次两步）一慢（一次一步），若有环，则while循环内两指针终会相遇（操场跑圈），
若无环，while循环会退出，返回false。
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode slow = head;			//快慢指针
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {	//判断fast.next前必须先判断fast不为空，不然在fast为空时，fast.next会空指针异常。
			if(fast == slow) return true;
			fast = fast.next.next;
			slow = slow.next;
		}

		return false;		//while循环跳出了，说明肯定无环。
	}
}

