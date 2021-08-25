package DFS.P94;

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

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 就真的是，dfs中序遍历。。

 时间复杂度：O(N)，每个节点都要访问一次。                                               打败100%
 空间复杂度：O(N)，递归调用栈深度，最坏情况下二叉树退化为链表，复杂度为O(N)。              打败85.26%
 */
class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null) {
            return;
        }

        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
