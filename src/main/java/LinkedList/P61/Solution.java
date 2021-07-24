package LinkedList.P61;

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
自己的解法，就是找到寻找需要剪切旋转的点，进行一下旋转操作即可，但是需要注意一些极端条件（链表为空，k%len==0）

时间复杂度：O(N)，N为链表长度。两次遍历，一次统计链表长度，一次寻找剪切点。                     打败100%
空间复杂度：O(1)。                                                                        打败54.42%
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;               //空链表，直接返回null。
        ListNode curr = head, tail = null;

        int len = 0;
        while(curr != null){                        //统计链表长度
            ++len;
            if(curr.next == null) tail = curr;      //顺便记录一下链表的tail节点。
            curr = curr.next;
        }

        if(k % len == 0) return head;               //旋转的次数是链表长度整数倍，相当于不旋转，直接返回。

        int step = len - (k % len) - 1;
        curr = head;
        for(int i = step; i > 0; i--){              //找到旋转剪切点，即newTail。
            curr = curr.next;
        }

        ListNode newHead = curr.next;               //newTail的后续节点就是newHead节点。
        curr.next = null;                           //进行旋转操作。
        tail.next = head;

        return newHead;                             //返回新的头结点。
    }
}
