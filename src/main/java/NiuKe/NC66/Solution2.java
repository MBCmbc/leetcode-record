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
别人的更简洁的写法，（剑指offer大佬题解的）
 */
public class Solution2 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null || pHead2==null) return null;
		ListNode p1 = pHead1, p2 = pHead2;
		while(p1 != p2){
			p1 = p1==null ? pHead2 : p1.next;
			p2 = p2==null ? pHead1 : p2.next;
		}

		return p1;
	}
}
