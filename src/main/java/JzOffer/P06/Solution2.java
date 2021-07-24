package JzOffer.P06;

import java.util.ArrayList;
import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
剑指Offer的思路二，递归本身就是一个栈结构，很自然的想到用递归来实现。

时间复杂度：O(N)，遍历链表，递归N次，以及for循环。                                  打败36.62%
空间复杂度：O(N)，递归调用的栈空间，以及额外的动态数组空间。                         打败6.72%
*/

class Solution2 {
	ArrayList<Integer> tmp = new ArrayList<>();
	public int[] reversePrint(ListNode head) {
		helpFunction(head);
		int[] res = new int[tmp.size()];
		for(int i=0; i<res.length; i++){
			res[i] = tmp.get(i);
		}
		return res;
	}

	void helpFunction(ListNode cur){
		if(cur == null) return;
		helpFunction(cur.next);
		tmp.add(cur.val);
	}
}
