package Tree.P98;

import Tree.TreeNode;

/*
https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
中序遍历，需要满足当前节点的值大于前一节点
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

class Solution2 {
	long pre = Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		//访问左子树
		if(!isValidBST(root.left)) return false;

		//访问当前节点
		if(root.val <= pre) return false;

		//更新pre的值
		pre = root.val;

		//访问右子树
		if(!isValidBST(root.right)) return false;

		//经历重重考验，都没有出错，说明没问题，返回TRUE
		return true;
	}
}
