package NiuKe.NC13;

import Tree.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
二叉树的最大深度，递归。
*/
public class Solution {
	/**
	 *
	 * @param root TreeNode类
	 * @return int整型
	 */
	private int res = 0;

	public int maxDepth (TreeNode root) {
		// write code here
		dfs(root, 0);
		return res;
	}

	public void dfs(TreeNode root, int depth){
		if(root == null){
			res = Math.max(res, depth);
			return;
		}

		dfs(root.left, depth + 1);
		dfs(root.right, depth + 1);
	}
}
