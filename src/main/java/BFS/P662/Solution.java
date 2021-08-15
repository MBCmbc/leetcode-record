package BFS.P662;

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
import java.util.Deque;

/**
 自己的做法，和官方题解思路一BFS相同，但我们这里直接在原树上修改了，没有额外定义节点。
 https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/

 1.根据满二叉树每个位置的编号规律，我们令树根的编号为1，则有：
 设当前节点编号为val，则左子节点编号为2 * val， 右子节点编号为2 * value + 1
 2.据此，我们把每一个节点的值修改为以上规律的编号，在BFS中，记录每一层最左侧节点的编号和最右侧节点的编号，二者之差就是当前层的宽度。
 3.用res记录并更新最大宽度即可。

 时间复杂度：O(N)，每一个节点我们都要访问。              打败100%
 空间复杂度：O(N)，BFS中queue的大小。                   打败81.33%
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        root.val = 1;           //修改树根节点为1，后续才能计算每个节点的编号。
        queue.offer(root);
        while(!queue.isEmpty()){            //BFS
            int size = queue.size();
            int left = 0, right = 0;        //每一层最左侧节点编号和最右侧节点编号
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(i == 0){                 //最左侧节点
                    left = curr.val;
                }
                if(i == size - 1){          //最右侧节点
                    right = curr.val;
                }

                //下一层节点更新编号并入队
                if(curr.left != null) {
                    curr.left.val = curr.val * 2;
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    curr.right.val = curr.val * 2 + 1;
                    queue.offer(curr.right);
                }
            }

            //计算当前层宽度，并更新记录最大宽度。
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
