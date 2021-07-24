package Tree.P98;

import Tree.TreeNode;

/*
官方解法
解法一：递归
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution1 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	private boolean helper(TreeNode curr, Integer lower, Integer upper){
		//终止条件，如果当前为空节点，表示遍历至最底层，没有错误
		if(curr == null) return true;

		int value = curr.val;
		//若当前节点值小于等于下界，说明不是二叉树搜索树，返回false
		if(lower != null && value <= lower) return false;
		//若当前节点值小于等于上界，说明不是二叉树搜索树，返回false
		if(upper != null && value >= upper) return false;

		//根据当前节点值对左子树确定上界，若左子树不满足，返回false
		if(!helper(curr.left, lower, value)) return false;
		//根据当前节点值对右子树确定下界，若右子树不满足，返回false
		if(!helper(curr.right, value, upper)) return false;

		//重重考验都经过了，说明以当前节点为根的子树是二叉搜索树，返回true
		return true;
	}
}
