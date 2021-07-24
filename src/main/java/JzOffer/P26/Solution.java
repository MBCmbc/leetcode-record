package JzOffer.P26;

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
剑指offer思路，加题解递归实现代码
https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
先序遍历树A，以树A的每个节点为根节点与树B进行匹配，直到找到相同结构为止。

时间复杂度：O(MN)，M为A树节点数，N为B树节点数。先序遍历A用O(M)，每次调用isSubTree占用O(N)。                         打败100%
空间复杂度：O(M)，最坏情况下A和B都退化为链表，此时递归调用深度最大。当M<=N，遍历树A与递归判断的总递归深度为M;           打败98.48%
            当M>N,最差情况是遍历到A的叶子节点，此时总递归深度为M。


空间复杂度要看在同一时刻，有多少递归函数未返回，而不是总共执行了多少函数。因为递归过程中是会回溯的，返回了的函数就不计入空间复杂度计算。
*/

class Solution {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		//三种情况：1.以当前节点为根即可匹配；2.在左子树中有对应子结构；3.在右子树中有对应子结构
		return (A!=null && B!=null) && (isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	boolean isSubTree(TreeNode A, TreeNode B){
		//B为空，匹配完完毕，返回。
		if(B == null) return true;
		//B不为空的情况下，A为空或A、B值不等都不匹配
		if((A==null) || (A.val!=B.val)) return false;
		//除了当前节点值要匹配，左子树和右子树也要对应匹配。
		return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
	}
}
