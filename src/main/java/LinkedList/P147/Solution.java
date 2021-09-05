package LinkedList.P147;

/**
 * @Author MBC
 * @Date 2021/9/5
 */

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
 链表的插入排序
https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/

思路：
1. 将链表分为已排序和待排序部分，初始时已排序部分只有一个head，剩下的部分都是待排序。
2. 每次将待排序部分的第一个节点插入到已排序部分中的合适位置，扩大已排序部分，缩小未排序部分。
3. 直到未排序部分全部被处理完。

时间复杂度：O(N*N)，每一个元素都要处理，每个元素处理时都需要从链表头开始遍历。                  打败99.10%
空间复杂度：O(1)。                                                                         打败83.77%
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //lastSorted代表已排序部分的最后一个【即最大值】，curr代表待排序的第一个，也是lastSorted的后一个元素
        ListNode lastSorted = head, curr = head.next;
        while(curr != null){
            if(lastSorted.val <= curr.val){
                //比最大值还大，curr直接加入已排序部分的末尾即可。
                lastSorted = curr;
            } else {
                ListNode prev = dummy;
                //寻找适当的插入位置
                //因为进入else的条件是lastSorted.val > curr.val，所以while循环一定是可以终止的，并且不会出现空指针异常。
                while(prev.next.val <= curr.val){
                    prev = prev.next;
                }
                //把curr放到已排序链表中适当的位置
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            //curr更新
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}
