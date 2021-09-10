package Tree.P572;

/**
 * @Author MBC
 * @Date 2021/9/9
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
大佬题解，递归判断。
https://leetcode-cn.com/problems/subtree-of-another-tree/solution/java-di-gui-ban-by-kelly2018/

subRoot是root的子树，那root中一定有一颗子树和subRoot结构完全相等。借用这个来递归地判断subRoot是否是root的子树。

时间复杂度：打败86.95%
空间复杂度：打败34.77%
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //特殊情况可直接返回
        if(subRoot == null) return true;
        if(root == null) return false;
        //subRoot是root的子树，要么两树完全相等，要么是左/右子树的子树
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //递归的方式，判断两棵树是否完全相等
    private boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
