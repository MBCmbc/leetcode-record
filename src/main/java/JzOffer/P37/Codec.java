package JzOffer.P37;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
同leetcode297
剑指offer思路，加leetcode297官方题解，方法一，深度优先搜索
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/

序列化时，用先序遍历的方式遍历二叉树，节点非空就以节点值作为序列化内容，节点null就以"None"作为序列化内容，标记此棵子树的结束；得到序列化字符串。
因为序列化结果的字符串不停地在变化，增加新内容。为提升运行速率，采用StringBuilder而不是String存储序列化结果，最后再转成String。

反序列化时，同样用先序遍历的思想，将字符串拆分为各个节点的值，重构出二叉树。

时间复杂度：O(N)，N为二叉树节点个数，遍历整颗二叉树。                                       打败91.33%
空间复杂度：O(N)，递归会使用栈空间。最坏情况下二叉树退化为链表，深度为N。                     打败74.47%

 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		return serializeRecur(root, sb).toString();
	}

	public StringBuilder serializeRecur(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append("None,");
		} else{
			//根、左、右
			//StringBuilder的append方法，可以链式调用，且参数可以为int类型
			sb.append(root.val).append(",");
			sb = serializeRecur(root.left, sb);
			sb = serializeRecur(root.right, sb);
		}

		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] split = data.split(",");
		List<String> dataList = new LinkedList<>(Arrays.asList(split));
		return deserializeRecur(dataList);
	}

	public TreeNode deserializeRecur(List<String> list){
		//空节点
		if(list.get(0).equals("None")){
			list.remove(0);
			return null;
		} else{
			//非空节点
			//Integer.parseInt返回int，Integer.valueOf返回Integer。此处使用前者避免不必要的装箱拆箱操作。
			TreeNode newNode = new TreeNode(Integer.parseInt(list.remove(0)));
			newNode.left = deserializeRecur(list);
			newNode.right = deserializeRecur(list);
			return newNode;
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
