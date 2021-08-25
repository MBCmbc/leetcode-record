package DFS.P129;

/**
 * @Author MBC
 * @Date 2021/8/25
 */

import Tree.TreeNode;

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
 自己的解法，dfs。
 逐步记录到当前节点为止所代表的值，如果是叶子节点就把值加到最终结果上。

 时间复杂度：O(N)，需要遍历整颗二叉树。                                                         打败100%
 空间复杂度：O(N)，最坏情况下，二叉树退化为链表，递归调用栈深度为链表长度。                         打败27.55%
 */
class Solution {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int value){
        if(root == null) return;

        value = value * 10 + root.val;
        //到达叶子节点，累加
        if(root.left == null && root.right == null){
            res += value;
            return;
        }

        //dfs左右子节点
        dfs(root.left, value);
        dfs(root.right, value);
    }
}
