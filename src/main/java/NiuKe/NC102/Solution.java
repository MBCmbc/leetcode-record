package NiuKe.NC102;

import Tree.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
同剑指offer P68_2，二叉树的最近公共祖先。
拉跨，还是没写出来。
*/
public class Solution {
	/**
	 * @param root TreeNode类
	 * @param o1   int整型
	 * @param o2   int整型
	 * @return int整型
	 */
	public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
		// write code here
		if (root == null) return -1;
		if (root.val == o1 || root.val == o2) return root.val;
		int left = lowestCommonAncestor(root.left, o1, o2);
		int right = lowestCommonAncestor(root.right, o1, o2);
		if (left < 0 && right < 0) return -1;
		if (left < 0) return right;
		if (right < 0) return left;
		return root.val;
	}
}
