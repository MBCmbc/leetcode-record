package LinkedList.P234;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

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
官方题解，方法一，先把链表内容存入数组，然后用双指针法判断。
https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/

时间复杂度：O(N)，链表填入数组需要遍历，双指针法也需要遍历。            打败21.72%
空间复杂度：O(N)，使用了一个额外数组。N为链表长度。                    打败14.31%
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
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
