package DFS.P145;

/**
 * @Author MBC
 * @Date 2021/9/2
 */

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
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
二叉树的后序遍历，非递归实现。
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/

用栈模拟递归过程：
1. 前序遍历是根、左、右，后序遍历是左、右、根
2. 我们实现对称的前序遍历，即：根、右、左，然后反转得到左、右、根，即可实现后序遍历。

时间复杂度：O(N)                    打败100%
空间复杂度：O(N)                    打败65.15%
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            //借助LinkedList的头插能力，实现序列反转。
            res.addFirst(curr.val);

            //因为栈先进后出，所以要实现根、右、左，就要先进左儿子，再进右儿子。
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }

        return res;
    }
}
