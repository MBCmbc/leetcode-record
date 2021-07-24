package Tree.P124;

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
//官方题解
/*
递归地，对每个节点计算其“最大贡献值”maxGain,也就是从这个节点开始往下走一条路径，把路径上的值都加起来所能得到和的最大值；

用一个全局变量maxSum表示最终的最大路径和，在每个节点的递归过程中，计算该节点的value + 左孩子的maxGain + 右孩子的maxGain，
并将结果与当前maxSum比较，取较大者，实时更新maxSum；
*/

class Solution {
	//用于存放最终结果，即最大路径和的全局变量
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return maxSum;
	}

	public int maxGain(TreeNode node){
		//若节点为空，maxGain为0
		if(node == null) return 0;

		//递归的获取左孩子和右孩子的maxGain，而且如果发现某个子节点的maxGain < 0就放弃该子节点，即路径不走该子节点，也即该子节点的贡献为0。
		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain = Math.max(maxGain(node.right), 0);

		//更新当前计算得到的最大路径和
		int nowSum = node.val + leftGain + rightGain;
		maxSum = Math.max(nowSum, maxSum);

		//返回当前节点的最大贡献值给父节点，即决定路径在当前节点往下走是走左孩子还是右孩子。
		return node.val + Math.max(leftGain, rightGain);
	}
}
