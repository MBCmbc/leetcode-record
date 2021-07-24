package JzOffer.P36;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

/*
剑指offer思路，大佬解法+代码
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/

利用二叉搜索树的中序遍历递增的特点，构建排序的循环双向链表
关键是利用pre记录已完成排序部分形成的链表的末尾节点，以便与后面节点形成双向链表

时间复杂度：O(N)，遍历树种每个节点各一次                                打败100%
空间复杂度：O(N)，最坏情况下树退化为链表，递归深度为N                    打败74.28%
*/

public class Solution {
	//pre是已经连接好的双向链表的最后一个节点。
	Node pre, head;
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		dfs(root);
		//根据pre的特点，dfs结束后，pre就是双向链表最后一个节点，为形成循环链表，需再将头尾相连
		head.left = pre;
		pre.right = head;
		return head;

	}

	void dfs(Node cur){
		//叶子节点下一层的空节点，无需加入到链表
		if(cur == null) return;
		dfs(cur.left);
		if(pre != null){
			pre.right = cur;
		} else{
			//若pre为空，说明现在要构建的链表里还没有东西，是空的。根据二叉排序树中序遍历的特点，当前节点就是最小的头结点
			head = cur;
		}
		cur.left = pre;
		//当前节点加入到链表后，就成了链表的最后一个节点（新的pre），更新pre后进入右子树的dfs
		pre = cur;
		dfs(cur.right);
	}
}
