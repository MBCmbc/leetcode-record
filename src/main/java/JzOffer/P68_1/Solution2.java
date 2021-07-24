package JzOffer.P68_1;

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
同leetcode P235
剑指offer思路，自己实现代码（循环/迭代/非递归方式）。
根据二叉搜索树的特点，从树根往下搜索，第一个满足p.val <= root.val <= q.val的节点即为所求（假设p.val < q.val）。

时间复杂度：O(N)，每轮循环排除一层，应为O(logN)，但最坏情况下二叉搜索树退化为单链表，可能需要遍历整个二叉搜索树。            打败100%
空间复杂度：O(1)，未使用额外空间。                                                                                   打败79.7%
 */
class Solution2 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;                       //输入为空指针直接返回
		while(root != null){
			if(root.val < p.val && root.val < q.val){       //情况1下，p和q都在root的右子树上，往右子树搜索。
				root = root.right;
			}else if(root.val > p.val && root.val > q.val){ //情况2下，p和q都在root的左子树上，往左子树搜索。
				root = root.left;
			} else{                                         //情况3下，当前节点即为所求，break后返回。
				break;
			}
		}

		return root;
	}
}
