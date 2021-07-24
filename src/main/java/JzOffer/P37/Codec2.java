package JzOffer.P37;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//同解法一，用StringJoiner稍微优化了一下

/*
同leetcode297
剑指offer思路，加leetcode297官方题解，方法一，深度优先搜索
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/

序列化时，用先序遍历的方式遍历二叉树，节点非空就以节点值作为序列化内容，节点null就以"None"作为序列化内容，标记此棵子树的结束；得到序列化字符串。
因为序列化结果的字符串不停地在变化，增加新内容。为提升运行速率，采用StringBuilder而不是String存储序列化结果，最后再转成String。

反序列化时，同样用先序遍历的思想，将字符串拆分为各个节点的值，重构出二叉树。

时间复杂度：O(N)，N为二叉树节点个数，遍历整颗二叉树。                                       打败91.33%
空间复杂度：O(N)，递归会使用栈空间。最坏情况下二叉树退化为链表，深度为N。                     打败74.47%
*/
public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner joiner = new StringJoiner(",");
        return dfs1(root, joiner).toString();
    }

    private StringJoiner dfs1(TreeNode curr, StringJoiner joiner){
        if(curr == null){
            joiner.add("null");
            return joiner;
        }

        //根、左、右
        joiner.add(String.valueOf(curr.val));
        joiner = dfs1(curr.left, joiner);
        joiner = dfs1(curr.right, joiner);
        return joiner;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodeVals = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(nodeVals);
    }

    private TreeNode dfs2(LinkedList<String> nodeVals){
        //空节点
        if("null".equals(nodeVals.getFirst())){
            nodeVals.removeFirst();
            return null;
        }

        //非空节点
        TreeNode curr = new TreeNode(Integer.valueOf(nodeVals.removeFirst()));
        curr.left = dfs2(nodeVals);
        curr.right = dfs2(nodeVals);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
