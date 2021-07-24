package JzOffer.P07;

import java.util.HashMap;

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
剑指offer思路，参考官方题解的方法一，递归思想。
https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/
    根据前序遍历和后序遍历的特点，确定左子树和右子树的位置以及节点个数，利用递归的方法层层构造子树并连接。

时间复杂度：O(N)，对于每个节点都有创建过程以及根据左右子树重建过程，初始化HashMap也需要O(N)。                                   打败97.72%
空间复杂度：O(N)，HashMap占O(N)空间，最坏情况下树退化为链表，递归调用栈深度为N，最好情况下为满二叉树，递归深度为logN。            打败86.04%
 */
class Solution {
	int[] preorder;
	int[] inorder;
	//中序遍历的反向映射，从值到索引，便于快速根据root的值找到其位置
	HashMap<Integer, Integer> indexMap = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null || preorder.length==0) return null;

		this.preorder = preorder;
		this.inorder = inorder;
		for(int i=0; i<inorder.length; i++){
			indexMap.put(inorder[i], i);
		}

		TreeNode root = buildTreeHelp(0, preorder.length-1, 0, inorder.length-1);
		return root;
	}

	//参数为：子树在preorder里的开始位置，子树在preorder里的结束位置，子树在inorder里的开始位置，子树在inorder里的结束位置。
	TreeNode buildTreeHelp(int preStart, int preEnd, int inStart, int inEnd){
		if(preStart > preEnd) return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		if(preStart == preEnd){
			return root;
		} else{
			int rootIndex = indexMap.get(root.val);
			//左、右子树上的节点数量
			int numLeft = rootIndex - inStart;
			int numRight = inEnd - rootIndex;
			TreeNode leftSub = buildTreeHelp(preStart+1, preStart+numLeft, inStart, rootIndex-1);
			TreeNode rightSub = buildTreeHelp(preStart+numLeft+1, preEnd, rootIndex+1, inEnd);
			root.left = leftSub;
			root.right = rightSub;
		}

		return root;
	}
}
