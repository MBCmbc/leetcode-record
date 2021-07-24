package JzOffer.P54;

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
 参考大佬的想法，自己实现了代码。
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
因为要找的是第K“大”的节点，所以可以采用“倒—中序遍历”，即右、根、左的方式，得到降序排列的节点值。
用一个变量d记录当前距离第K大的节点还有多远。当d为0时，说明找到第K大的节点，即刻返回。

时间复杂度：O(N)，N为二叉搜索树节点数目，最坏情况下，遍历所有节点。             打败100%
空间复杂度：O(N)，最坏情况下，树退化为链表，递归调用栈深度为N。                 打败61.95%
 */
class Solution2 {
	private int d, res;
	public int kthLargest(TreeNode root, int k) {
		d = k;
		recur(root);
		return res;
	}

	void recur(TreeNode root){
		if(root == null) return;

		recur(root.right);              //右
		if(d == 0) return;              //已经找到了，提前返回的语句，剪枝。
		if(--d == 0){                   //根，找到第K大元素，赋予res，并剪枝。
			res = root.val;
			return;
		}
		recur(root.left);               //左
	}
}
