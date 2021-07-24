package NiuKe.NC66;

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
两个链表的第一个公共节点，同剑指offer P52
 */
public class Solution {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null || pHead2==null) return null;
		ListNode p1 = pHead1, p2 = pHead2;
		while(p1!=null || p2!=null){
			if(p1==p2) return p1;

			if(p1 == null) p1 = pHead2;
			else p1 = p1.next;

			if(p2 == null) p2 = pHead1;
			else p2 = p2.next;
		}

		return null;
	}
}
