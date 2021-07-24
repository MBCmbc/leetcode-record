package JzOffer.P55_1;

import Tree.TreeNode;
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
同leetcode P104
自己的想法，+代码实现。
用前序遍历的方式遍历整棵树，同时记录当前的深度（depth+1），用一个全局变量res记录最大深度。

时间复杂度：O(N)，N为二叉树节点个数，需要遍历所有节点。                     打败100%
空间复杂度：O(N)，最坏情况下，二叉树退化为链表，递归调用栈深度为N。         打败42.44%
 */
class Solution1 {
	private int res = 0;
	public int maxDepth(TreeNode root) {
		recur(root, 0);
		return res;
	}

	void recur(TreeNode root, int depth){   //depth表示到父节点为止的深度
		if(root == null){
			res = Math.max(depth, res);
			return;
		}

		recur(root.left, depth+1);          //递归遍历左子树和右子树。
		recur(root.right, depth+1);
	}
}
