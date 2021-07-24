package JzOffer.P34;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

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
同leetcode113
剑指offer思路，+大佬代码
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
题目要求的路径是从根节点一直到叶子节点，很明显可以用回溯的方法，利用递归的方式实现，每到一个节点记录下剩余的target（其实也就是已经加了多少），以及路径。到叶子节点判断是否已经满足目标和要求，是则将路径加入到结果集合。

注意，返回上一层时要把当前节点从path中去除，当全局使用同一个path时必须注意回溯前的“清扫战场”工作。

时间复杂度：O(N)，DFS遍历每个节点一次。                                                             打败29.52%
空间复杂度：O(N)，最坏情况下树退化为链表，栈空间最多N层(递归至树叶，所有节点都在调用栈中)。              打败20.15%
 */
class Solution {
	private List<List<Integer>> res = new LinkedList<>();
	private LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		recur(root, sum);
		return res;
	}

	void recur(TreeNode root, int target){
		if(root == null) return;
		path.add(root.val);
		target -= root.val;
		//到达叶子结点，且恰得到目标和，添加结果。但因为java传递的是引用，所以要new一个新的List，重新装一下path。
		if(target == 0 && root.left == null && root.right == null) res.add(new LinkedList<>(path));

		recur(root.left, target);
		recur(root.right, target);
		//回溯前，在path中去掉当前节点，打扫战场。
		path.removeLast();
	}
}
