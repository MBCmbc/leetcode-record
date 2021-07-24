package NiuKe.NC15;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
同剑指offer P32-2
*/
public class Solution {
	/**
	 *
	 * @param root TreeNode类
	 * @return int整型ArrayList<ArrayList<>>
	 */
	public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
		// write code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> subRes = new ArrayList<>();
			int queueSize = queue.size();
			for(int i = 0; i < queueSize; i++){
				TreeNode node = queue.poll();
				subRes.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			res.add(subRes);
		}

		return res;
	}
}
