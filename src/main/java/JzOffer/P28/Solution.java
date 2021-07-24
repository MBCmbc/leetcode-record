package JzOffer.P28;

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
同leetcode第101题，剑指offer思路
下面链接的官方思路也是一样的，只是描述方法上有不同。
https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
用一种对称的先序遍历（根右左），和正常的先序遍历（根左右）对比，遍历出来的序列是一致的，就说明二叉树对称（空节点也要考虑）

时间复杂度：O(N)，遍历了树上的所有节点，N为二叉树上的节点个数                   打败100%
空间复杂度：O(N)，最坏情况下二叉树退化为链表，递归调用栈深度为N。               打败82.05%
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return check(root, root);
		//return check(root.left, root.right);   //根的左右子树互为镜像对称，也说明树是对称的
	}

	//p表示进行正常先序遍历的树，q表示进行对称先序遍历的树
	//对同一棵树同时进行正常遍历和对称遍历，相当于对树和树的镜像对称同时做正常遍历
	//如果遍历出来的序列相等的话，就说明原树是对称的。
	//也可以理解为check函数的作用是检查树p和树q是否镜像对称，如果树和自身是镜像对称的，就说明树是对称的
	boolean check(TreeNode p, TreeNode q){
		if(p==null && q==null) return true;

		if(p==null || q==null) return false;

		return (p.val==q.val) && check(p.left, q.right) && check(p.right, q.left);
	}
}
