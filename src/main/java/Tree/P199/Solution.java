package Tree.P199;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
 题解方法二：DFS
https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
思路：按照根、右、左的顺序进行dfs遍历，就可以保证每层都是先访问最右边的节点。

时间复杂度：O(N)，N为树中节点的个数，每个节点都访问了一次。             打败99.08%
空间复杂度：O(N)，最坏情况下退化为链表，递归栈深度为N。                 打败54.43%
 */
class Solution {
	List<Integer> res = new ArrayList<>();;
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null) return res;
		dfs(root, 0);   //根节点深度为0
		return res;
	}

	public void dfs(TreeNode root, int depth){
		if(root == null) return;
		//如果当前层的节点还没有任何一个被加入到res里，说明当前节点就是本层第一个访问的节点，也就是最右视图。
		if(depth == res.size()) res.add(root.val);

		dfs(root.right, depth+1);
		dfs(root.left, depth+1);
	}
}
