package JzOffer.P32_3;

import java.util.*;

import Tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
与P32-2完全一样的思路，只不过用LinkedList作为subRes，利用LinkedList可以在头部插入也可以在尾部插入的特点，
奇数层挨个插入在尾部，表示正序输出；偶数层挨个插入到头部，表示倒序输出，从而完成之字形打印。

//另外一种思路，也可以完全和P32-2一样，只不过在偶数层也正序添加完后，使用Collections.reverse()将subRes进行倒序。即为大佬的方法三：层序遍历+倒序

时间复杂度：O(N)，N为二叉树节点数量                                                 打败99.76%
空间复杂度：O(N)，最坏情况，平衡二叉树，queue中最多N/2个节点（最后一层）。              打败68.82%
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while(!queue.isEmpty()){
			//注意要声明成LinkedList，不然无法使用addLast()和addFirst()
			LinkedList<Integer> subRes = new LinkedList<>();
			for(int i = queue.size(); i > 0; i--){
				TreeNode node = queue.poll();
				if((res.size() & 1) == 0){
					//res.size为偶，标明当前为奇数层
					subRes.addLast(node.val);
				} else{
					subRes.addFirst(node.val);
				}
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			res.add(subRes);
		}

		return res;
	}
}
