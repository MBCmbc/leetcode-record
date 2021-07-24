package JzOffer.P54;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
剑指offer思路，自己实现的，也是最简单最直接的写法。
中序遍历二叉搜索树，得到中序遍历结果并存储在动态数组中，取出倒数第k个即可。

时间复杂度：O(N)，N为二叉搜索树节点个数，需要遍历整个二叉树。               						打败42.73%
空间复杂度：O(N)，额外的数组空间存储中序遍历结果。 当树退化为链表时，递归调用栈的深度也为N。       打败21.98%
 */
class Solution1 {
	private List<Integer> list = new ArrayList<Integer>();
	public int kthLargest(TreeNode root, int k) {
		recur(root);
		return list.get(list.size() - k);
	}

	private void recur(TreeNode root){
		if(root == null) return;

		recur(root.left);
		list.add(root.val);
		recur(root.right);
	}
}
