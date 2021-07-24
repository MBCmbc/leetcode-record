package BFS.P102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
同剑指offer  P32_2
大佬解法：
https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/
与普通的BFS题目不同点就在于如何分层。要注意到，每一层刚开始遍历时，队列queue中节点的个数恰好就是当前层的节点个数，
故而可以用queue.size()作为for循环次数，完成一层的遍历。

时间复杂度：O(N)，N为二叉树节点数量                                                         打败93.08%
空间复杂度：最坏情况，平衡二叉树，queue中最多N/2个节点（最后一层）。                            打败62.19%

 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while(!queue.isEmpty()){
			List<Integer> subRes = new ArrayList<>();
			//上一层结束后，本层开始前，queue.size()就是当前层的节点个数。
			for(int i = queue.size(); i > 0; i--){
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
