package LinkedList.P82;

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
2021.4.9,美团二面算法题
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
思路很简单，就是遍历、判重、删除，但是要注意空指针异常等边界条件。

时间复杂度：O(N)，遍历整个链表。            打败71.07%
空间复杂度：O(1)                          打败74.14%
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1000);   //dummy节点，方便判重和返回。   //因为头结点也可能被删除，所以必须有一个dummy节点。
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){     //注意这些边界条件，避免空指针异常
            if(curr.next.val == curr.next.next.val){    //出现重复
                int x = curr.next.val;
                while(curr.next != null && curr.next.val == x){ //删除所有的重复元素，注意空指针异常
                    curr.next = curr.next.next;
                }
            } else {    //不重复，指针后移。
                curr = curr.next;
            }
        }

        return dummy.next;      //返回头结点。
    }
}