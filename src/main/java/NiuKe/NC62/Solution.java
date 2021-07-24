package NiuKe.NC62;

/*
判断一棵二叉树是否为平衡二叉树，同leetcode P110
自己写的，但是没剪枝。不能算是最优。
剪枝了的最优解法可以取看看leetcode上的
*/

import Tree.TreeNode;

public class Solution {
	boolean res = true;

	public boolean IsBalanced_Solution(TreeNode root) {
		dfs(root);
		return res;
	}

	public int dfs(TreeNode curr){
		if(curr == null) return 0;

		int ld = dfs(curr.left);
		int rd = dfs(curr.right);
		int dis = ld - rd;
		if(dis < -1 || dis > 1) res = false;
		return Math.max(ld, rd) + 1;
	}
}
