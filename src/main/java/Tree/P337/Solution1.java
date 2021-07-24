package Tree.P337;


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
https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
解法一:暴力递归
*/

class Solution1 {
	public int rob(TreeNode root) {
		//如果节点为空，抢到的钱为0
		if(root == null) return 0;

		int money = root.val;

		//如果左孩子不为空，起码确保可以访问到孙子（有节点或者null），若孙子节点为null，根据终止条件，则抢到0元。
		if(root.left != null){
			money += (rob(root.left.left) + rob(root.left.right));
		}

		//右子树同理
		if(root.right != null){
			money += (rob(root.right.left) + rob(root.right.right));
		}

		//（爷爷+四个孙子的钱）VS（两个儿子的钱），哪个多抢哪个
		return Math.max(money, rob(root.left) + rob(root.right));
	}
}
