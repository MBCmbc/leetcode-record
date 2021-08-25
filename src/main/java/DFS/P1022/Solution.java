package DFS.P1022;

/**
 * @Author MBC
 * @Date 2021/8/24
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

1. 以dfs的方式遍历每个节点，同时记录到当前节点为止所记录的二进制数的值；
2. 如果发现是叶子节点就把值加到res上，否则继续向下dfs。

时间复杂度：O(N)，要遍历整颗树。                                                                        打败100%
空间复杂度：O(N)，最坏情况下，树退化为链表，递归栈的深度为链表深度，即节点个数N。                           打败65.47%
 */
class Solution {
    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int value){
        if(root == null) return;        //终止条件

        value = (value << 1) + root.val;    //新value，即到当前节点为止，二进制数的值。
        if(root.left == null && root.right == null){        //如果是叶子节点，value值加到结果上，返回。
            res += value;
            return;
        }

        //到此还没返回，说明不是叶子节点，继续向下dfs。
        dfs(root.left, value);
        dfs(root.right, value);
    }
}
