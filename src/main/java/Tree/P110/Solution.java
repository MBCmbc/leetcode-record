package Tree.P110;

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
同剑指offer P55-2
参考大佬题解，方法一：后序遍历+剪枝（自底至顶）
https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
参考剑指offer P55-1的思路，自底向上计算每个节点的最大深度。

recur函数：
    返回值：
        1. 对于每个节点，当左右子树的深度差<=1，返回自己的深度，即max(leftDepth, rightDepth) + 1；
        2. 若差>1，则返回-1，表示已经可以断定为非平衡二叉树。
    终止条件：
        1. 当root为null，表示已越过叶子节点，返回高度0；
        2. 当左/右子树深度为-1，表明不是平衡二叉树，可以剪枝，直接返回-1。

主函数：
    若recur(root) != -1，说明是平衡二叉树，返回true，否则返回false。

时间复杂度：O(N)，N为二叉树节点个数。二叉树平衡时，需要遍历整颗二叉树。                 打败100%
空间复杂度：O(N)，最坏情况下二叉树退化为链表，递归调用栈深度为N。                       打败38.69%
 */
class Solution {
	public boolean isBalanced(TreeNode root) {
		return recur(root) != -1;
	}

	int recur(TreeNode root){
		if(root == null) return 0;                          //终止条件，越过叶子节点，返回高度0。

		int leftDepth = recur(root.left);                   //左子树深度
		if(leftDepth == -1) return -1;                      //若左子树深度为-1，表示不平衡，剪枝，返回-1。

		int rightDepth = recur(root.right);                 //右子树同理
		if(rightDepth == -1) return -1;

		int dis = leftDepth - rightDepth;                   //左右子树均各自平衡，查看当前节点是否满足平衡。
		if(dis < -1 || dis > 1) return -1;                  //若不平衡，剪枝，返回-1。

		return Math.max(leftDepth, rightDepth) + 1;         //通过层层考验，是平衡的，返回以当前节点为根的子树的深度。
	}
}
