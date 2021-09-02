package DFS.P94;

/**
 * @Author MBC
 * @Date 2021/9/2
 */
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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 二叉树的中序遍历，非递归实现。
 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/

 用栈模拟递归过程，实现左、根、右的中序遍历。
 1. 尽可能的将这个节点的左子树压入Stack，此时栈顶的元素是最左侧的元素，其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，并且在寻找的过程中记录了来源，才能返回上层,同时在返回上层的时候已经处理完毕左子树了。
 2. 当处理完最小单位的子树时，返回到上层处理了中间节点。（如果把整个左中右的遍历都理解成子树的话，就是处理完 左子树->中间(就是一个节点)->右子树）
 3. 如果有右节点，其也要进行中序遍历。

 时间复杂度：O(N)       打败100%
 空间复杂度：O(N)       打败61.05%
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            //1.一直往左下走，直到找到当前子树的最左侧节点。[while结束时curr == null，即一个空节点]
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            //2. 处理左子节点的根节点
            TreeNode curr = stack.pop();
            res.add(curr.val);
            //3. 如果有右子节点，也要进行处理
            if(curr.right != null){
                node = curr.right;
            }
        }

        return res;
    }
}
