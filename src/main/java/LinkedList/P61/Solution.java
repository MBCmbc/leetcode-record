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
自己的解法，就是找到寻找需要剪切旋转的点【倒数第k个节点，作为新的head】，进行一下旋转操作即可，但是需要注意一些极端条件（链表为空，k%len==0）

时间复杂度：O(N)，N为链表长度。两次遍历，一次统计链表长度，一次寻找剪切点。                     打败100%
空间复杂度：O(1)。                                                                        打败54.42%
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;     //空链表或无需旋转

        ListNode curr = head;
        int len = 0;
        while(curr != null){    //统计链表长度
            ++len;
            curr = curr.next;
        }

        k = k % len;        //去除k中冗余的部分
        if(k == 0) {        //无需旋转
            return head;
        }

        //找到倒数第k个节点的前一个节点
        ListNode fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //此时slow为倒数第k个节点的前一个节点，fast为尾节点

        //剪切，重新拼接，达到旋转的效果。
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
