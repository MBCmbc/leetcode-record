package JzOffer.P68_2;

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
同leetcode P236
参考大佬解法和代码：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
通过递归对二叉树进行先序遍历，遇到节点p或节点q时返回。从底至顶回溯，当p，q在root的异侧时，root即为最近公共祖先，则向上返回root。
最终找到的最近公共祖先将被一层一层地向上返回，直至最外层递归的返回。

时间复杂度：O(N)，N为二叉树节点数，最坏情况下需要遍历整个二叉树。                       打败99.98%
空间复杂度：O(N)，最坏情况下，二叉树退化为链表，且p/q位于最底层，递归深度达到N。         打败31.66%
 */
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//终止条件：1.越过叶节点，直接返回null；2.root等于p,q，返回root。
		if(root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);      //递归左子节点
		TreeNode right = lowestCommonAncestor(root.right, p, q);    //递归右子节点
		if(left == null && right == null) return null;  //情况1.左右均为null，即root的左右子树都不包含p/q，返回null。
        /*情况2.左null，右不null。右子树包含p/q。具体可分为两种情况
              1.p,q其中一个在root的右子树中，此时right指向p/q。
              2.p,q都在root的右子树中，此时right指向最近公共祖先      */
		if(left == null) return right;
		if(right == null) return left;           //情况3.左不null，右null。左子树包含p/q。
		return root;                             //情况4.左右均不为null，此时p,q分处root两侧，root即为最近公共祖先。
	}
}
