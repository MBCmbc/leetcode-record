package Tree.P337;

import Tree.TreeNode;

import java.util.HashMap;

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
https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
解法二:在解法一的基础上，解决重复子问题。
*/

class Solution2 {
	public int rob(TreeNode root) {
		HashMap<TreeNode, Integer> map = new HashMap<>();
		return robHelper(root, map);
	}

	private int robHelper(TreeNode root, HashMap<TreeNode, Integer> map){
		//如果节点为空，抢到的钱为0
		if(root == null) return 0;

		//如果已经计算过该节点，直接返回已经计算的结果。
		if(map.containsKey(root)) return map.get(root);

		int money = root.val;
		//如果左孩子不为空，起码确保可以访问到孙子（有节点或者null），若孙子节点为null，根据终止条件，则抢到0元。
		if(root.left != null){
			money += (robHelper(root.left.left, map) + robHelper(root.left.right, map));
		}

		//右子树同理
		if(root.right != null){
			money += (robHelper(root.right.left, map) + robHelper(root.right.right, map));
		}

		//（爷爷+四个孙子的钱）VS（两个儿子的钱），哪个多抢哪个
		int result = Math.max(money, robHelper(root.left, map) + robHelper(root.right, map));
		//将计算结果存储到哈希表里面
		map.put(root, result);
		return result;
	}
}
