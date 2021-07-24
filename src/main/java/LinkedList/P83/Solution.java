package LinkedList.P83;

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
自己实现的不太优雅，参照下面这个实现了。
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/hua-jie-suan-fa-83-shan-chu-pai-xu-lian-biao-zhong/
思路没什么，就是遍历判重并删除，就是代码实现起来要尽可能简单。

时间复杂度：O(N)        打败100%
空间复杂度：O(1)        打败44.1%
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode curr = head;
        while(curr != null && curr.next != null){   //判断一下curr.next，防止空指针异常
            if(curr.val == curr.next.val) curr.next = curr.next.next;   //删除重复节点，但指针不后移，因为可能不止一个重复节点，所以下一次while循环继续判断。
            else curr = curr.next;  //无重复，指针后移。
        }

        return head;    //每个元素都留下了至少一个，所以原head肯定还存在的，返回原head即可。
    }
}
