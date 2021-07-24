package NiuKe.NC8;

import Tree.TreeNode;

import java.util.ArrayList;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
/*
同剑指offer P34、Leetcode P113
*/
public class Solution {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        if(root == null) return res;

        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode curr, int target){
        if(curr == null) return;
        path.add(curr.val);
        int newTarget = target - curr.val;
        if(newTarget == 0 && curr.left == null && curr.right == null) res.add(new ArrayList<Integer>(path));

        dfs(curr.left, newTarget);
        dfs(curr.right, newTarget);
        path.remove(path.size() - 1);
    }
}
