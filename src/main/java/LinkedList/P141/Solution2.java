package LinkedList.P141;

import LinkedList.ListNode;
/*
在牛客上刷到了，再做一遍。
 */
public class Solution2 {
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
