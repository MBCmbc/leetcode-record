package NiuKe.NC16;

import Tree.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
同剑指offer P28，拉跨，还是没写出来。  2021.3.11
*/
public class Solution {
	/**
	 *
	 * @param root TreeNode类
	 * @return bool布尔型
	 */
	public boolean isSymmetric (TreeNode root) {
		// write code here
		if(root == null) return true;
		return check(root, root);
	}

	public boolean check(TreeNode node1, TreeNode node2){
		if(node1==null && node2==null) return true;
		if(node1==null || node2==null) return false;
		return node1.val==node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
	}
}
