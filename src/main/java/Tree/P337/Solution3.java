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
解法三
*/

class Solution3 {
	public int rob(TreeNode root) {
		int[] result = robHelper(root);
		return Math.max(result[0], result[1]);
	}

	private int[] robHelper(TreeNode root){
		//root为空，返回空的int数组。
		if(root == null) return new int[2];
		//存储结果用的数组
		int[] result = new int[2];

		//分别递归查询左右子树的得到的结果数组。
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);

		//填充结果
		//0表示本节点不偷，那结果就是左孩子能偷到的最大值+右孩子能偷到的最大值。（左右孩子各自偷不偷无所谓）.
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//1表示本节点偷，那结果就是本节点偷到的钱+左孩子不偷得到的钱+右孩子不偷得到的钱.
		result[1] = root.val + left[0] + right[0];

		return result;
	}
}
