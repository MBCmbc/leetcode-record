package JzOffer.P32_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
很显然，就是BFS。
时间复杂度：O(N)，N为二叉树节点数量，即BFS需循环N次                                                                          打败99.79%
空间复杂度：O(N)，最坏情况下，树为平衡二叉树(大概就是最后一层)，最多有N/2个节点同时在queue中，使用O(N)大小额外空间                 打败67.39%
 */
class Solution {
	public int[] levelOrder(TreeNode root) {
		if (root == null) return new int[0];

		ArrayList<Integer> list = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}

		int len = list.size();
		int[] res = new int[len];
		for(int i = 0; i < len; i++){
			res[i] = list.get(i);
		}

		return res;
	}
}