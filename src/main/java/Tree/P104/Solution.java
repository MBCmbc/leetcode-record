package Tree.P104;

import Tree.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
同剑指offer P55-1
剑指offer思路，+大佬题解
https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
充分理解递归函数定义时的用途和含义！（根据函数的定义来实现递归调用，而不用过分多的考虑调用过程。
                                     这个函数到底是用来干什么的？返回值的意义是什么？）

后序遍历DFS，（从下往上看）当前节点的最大深度，是左子树和右子树二者中的最大深度，再加1。

时间复杂度：O(N)，N为二叉树节点个数，需要遍历整颗二叉树。                                       打败100%
空间复杂度：O(N)，最坏情况下，二叉树退化为链表，递归调用栈深度为N。                             打败26.13%
 */
class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
