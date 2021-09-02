package DFS.P144;

/**
 * @Author MBC
 * @Date 2021/9/2
 */

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
二叉树前序遍历的非递归实现，用栈模拟递归过程。
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/

前序遍历需要的顺序是左、根、右，我们用栈模拟递归过程，因为栈是先入后出的，所以儿子入栈的时候应该先入右儿子，再入左儿子。

时间复杂度：O(N)，遍历整棵树。                              打败100%
空间复杂度：O(N)，树退化为链表时，栈的深度。                  打败89.83%
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);

            //入栈时，先入左子节点，再入右子节点。这样出栈时才能先左后右。
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }

        return res;
    }
}
