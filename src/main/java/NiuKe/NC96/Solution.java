package NiuKe.NC96;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
/*
判断回文链表，同leetcode P234，先把链表元素存入数组，然后双指针法判断。
*/
public class Solution {
	/**
	 *
	 * @param head ListNode类 the head
	 * @return bool布尔型
	 */
	public boolean isPail (ListNode head) {
		// write code here
		if(head == null) return true;
		List<Integer> list = new ArrayList<>();
		ListNode curr = head;
		while (curr != null){       //链表元素存入数组
			list.add(curr.val);
			curr = curr.next;
		}

		int left = 0, right = list.size() - 1;
		while(left < right){        //双指针法判断。
			if(!list.get(left).equals(list.get(right))) return false;
			left++;
			right--;
		}

		return true;
	}
}
