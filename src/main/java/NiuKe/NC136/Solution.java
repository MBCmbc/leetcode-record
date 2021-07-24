package NiuKe.NC136;

import java.util.*;

/*
先根据先序遍历和中序遍历额结果重建二叉树；                    同剑指offer P07
然后再用根、右、左的遍历顺序，得到二叉树的右视图。             同leetcode P199
*/
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 求二叉树的右视图
	 *
	 * @param xianxu int整型一维数组 先序遍历
	 * @param zhongxu int整型一维数组 中序遍历
	 * @return int整型一维数组
	 */
	private HashMap<Integer, Integer> midMap = new HashMap<>();
	private int[] pre;
	private int[] mid;
	ArrayList<Integer> tmp = new ArrayList<>();

	public int[] solve(int[] xianxu, int[] zhongxu) {
		// write code here
		if (xianxu == null || xianxu.length == 0) return new int[0];
		pre = xianxu;
		mid = zhongxu;
		for (int i = 0; i < mid.length; i++) midMap.put(mid[i], i);
		TreeNode root = build(0, pre.length - 1, 0, mid.length - 1);
		helper(root, 0);
		int[] res = new int[tmp.size()];

		for (int i = 0; i < tmp.size(); i++) res[i] = tmp.get(i);
		return res;
	}

	public void helper(TreeNode curr, int depth) {
		if (curr == null) return;

		if (depth == tmp.size()) tmp.add(depth, curr.val);
		helper(curr.right, depth + 1);
		helper(curr.left, depth + 1);
	}

	private TreeNode build(int preStart, int preEnd, int midStart, int midEnd) {
		if (preStart > preEnd) return null;

		int rootVal = pre[preStart];
		int midIdx = midMap.get(rootVal);
		int leftLen = midIdx - midStart;
		int rightLen = midEnd - midIdx;

		TreeNode curr = new TreeNode(rootVal);
		curr.left = build(preStart + 1, preStart + leftLen, midStart, midIdx - 1);
		curr.right = build(preStart + leftLen + 1, preEnd, midIdx + 1, midEnd);

		return curr;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}
}
