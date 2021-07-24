package JzOffer.P27;

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
剑指offer的递归思路，+题解实现代码。
https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
方法一，递归法。
为求所谓镜像，递归的为每个节点交换左右子树即可，以前序遍历的方式

时间复杂度：O(N)，每个节点都要遍历并操作                                                        打败100%
空间复杂度：O(N)，最坏情况下，二叉树退化为链表，递归需要使用O(N)大小的栈空间                        打败97.65%
 */
class Solution {
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) return null;

		TreeNode tmp = root.left;
		root.left = mirrorTree(root.right);
		root.right = mirrorTree(tmp);

		return root;
	}
}
