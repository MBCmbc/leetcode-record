package NiuKe.NC12;

import Tree.TreeNode;

import java.util.HashMap;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
同剑指offer P07，自己做出来了！
 */
public class Solution {
	private int[] pre, in;
	private HashMap<Integer, Integer> idxMap = new HashMap<>();
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		this.pre = pre;
		this.in = in;
		for(int i=0; i < in.length; i++) idxMap.put(in[i], i);
		return helper(0, pre.length-1, 0, in.length-1);

	}

	public TreeNode helper(int startPre, int endPre, int startIn, int endIn){
		if(startPre > endPre) return null;

		int rootVal = pre[startPre];
		TreeNode root = new TreeNode(rootVal);
		int rootIdx = idxMap.get(rootVal);

		int lenLeft = rootIdx - startIn;
		int lenRight = endIn - rootIdx;

		TreeNode left = helper(startPre+1, startPre+lenLeft, startIn, rootIdx - 1);
		TreeNode right = helper(startPre+lenLeft+1, endPre, rootIdx+1, endIn);
		root.left = left;
		root.right = right;
		return root;
	}
}
