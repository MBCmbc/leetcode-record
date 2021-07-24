package NiuKe.NC45;

import Tree.TreeNode;

import java.util.ArrayList;

/*
 * public class TreeNode {
 *   int value = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

/*
使用递归，实现二叉树的前序遍历、中序遍历和后序遍历。
*/

public class Solution {
	/**
	 *
	 * @param root TreeNode类 the root of binary tree
	 * @return int整型二维数组
	 */
	public int[][] threeOrders (TreeNode root) {
		// write code here
		ArrayList<Integer> tmp = new ArrayList<>();

		preorder(root, tmp);
		int size = tmp.size();
		int[][] res = new int[3][size];
		for(int i = 0; i < size; i++) res[0][i] = tmp.get(i);

		tmp.clear();
		inorder(root, tmp);
		for(int i = 0; i < size; i++) res[1][i] = tmp.get(i);

		tmp.clear();
		postorder(root, tmp);
		for(int i = 0; i < size; i++) res[2][i] = tmp.get(i);

		return res;
	}

	private void preorder(TreeNode root, ArrayList<Integer> pre){
		if(root == null) return;
		pre.add(root.val);
		preorder(root.left, pre);
		preorder(root.right, pre);
	}

	private void inorder(TreeNode root, ArrayList<Integer> in){
		if(root == null) return;
		inorder(root.left, in);
		in.add(root.val);
		inorder(root.right, in);
	}

	private void postorder(TreeNode root, ArrayList<Integer> post){
		if(root == null) return;
		postorder(root.left, post);
		postorder(root.right, post);
		post.add(root.val);
	}
}
