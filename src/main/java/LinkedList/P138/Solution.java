package LinkedList.P138;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
同剑指offer P35
剑指offer的三步走思路，也是138题官方题解的方法三：O(1)空间的迭代。
https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
第一步：遍历原链表，为每个节点创建一个拷贝节点，放在原节点的next位置上，形成“旧→新→旧→新→旧→新......”的交替链表。
第二步：遍历交替链表，找到旧节点的random指针所指，若不为空，则旧节点random的next节点就是新节点的random所应指的节点。
第三步：遍历链表，将新旧节点进行拆分，得到独立的旧链表和新链表。

时间复杂度：O(N)，遍历了三遍链表                                                    打败100%
空间复杂度：O(1)，除结果“新链表”外，只用了常数级别的额外空间                           打败40.19%
*/
public class Solution {
	public Node copyRandomList(Node head) {
		if(head == null) return null;

		//第一步，创建新节点，形成交替链表
		Node ptr = head;
		while(ptr != null){
			Node newNode = new Node(ptr.val);
			newNode.next = ptr.next;
			ptr.next = newNode;
			ptr = newNode.next;
		}

		//第二步，为新节点的random赋值
		ptr = head;
		while(ptr != null){
			//注意，旧节点的random可能为空，这种情况下直接给新节点random赋null。
			//若还用ptr.random.next会导致空指针异常
			ptr.next.random = ptr.random == null ? null : ptr.random.next;
			ptr = ptr.next.next;
		}

		//拆分新旧链表
		ptr = head;
		Node ptr_new = head.next;
		Node ptr_res = head.next;
		while(ptr != null){
			ptr.next = ptr_new.next;
			//注意，到最后一对“旧→新”节点时，ptr.next可能为空。同理直接为ptr_new.next赋null即可，否则会有空指针异常。
			ptr_new.next = ptr.next == null ? null : ptr.next.next;
			ptr = ptr.next;
			ptr_new = ptr_new.next;
		}

		return ptr_res;
	}
}
