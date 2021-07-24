package NiuKe.NC14;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
二叉树的之字形层序遍历，同剑指Offer P32-3
*/
public class Solution {
	/**
	 *
	 * @param root TreeNode类
	 * @return int整型ArrayList<ArrayList<>>
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
		// write code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int depth = 1;
		while(!queue.isEmpty()){
			int count = queue.size();
			ArrayList<Integer> subRes = new ArrayList<>();
			for(int i=0; i<count; i++){
				TreeNode curr = queue.poll();
				subRes.add(curr.val);
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
			if(depth%2 == 0) Collections.reverse(subRes);
			res.add(subRes);
			++depth;
		}

		return res;
	}
}
