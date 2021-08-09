package Tree.P103;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
自己的解法，就用原始的BFS算法，但是在往结果里存储的时候，按照层次区分，奇数层依次往子链表末尾添加，偶数层依次往子链表头部添加。

对于存储结果的“大”链表的处理无异，关键在于“大”链表中每个子链表的处理；
偶数层在往该层所对应的子链表里添加元素时，需要反向添加，即每次添加元素至链表头，而非链表尾；
奇数层无异。
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		//用于存储最终结果的集合
		List<List<Integer>> result = new LinkedList<>();
		//如果树为空，直接返回。
		if(root == null) return result;
		//用于BFS的队列，并加入root，初始化。
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		//用于标记是否反向添加结果的标志
		boolean reverse = false;
		while(!q.isEmpty()){
			//一定要声明变量提前取到q.size()，不可以在for循环中直接用q.size()，因为其会随队列的变化而不断变化。
			int size = q.size();
			//注意List没有addFirst和addLast方法，所以需要声明为LinkedList。(ArrayList也没有)
			LinkedList<Integer> subList = new LinkedList<>();
			for(int i=0; i<size; ++i){
				TreeNode curr = q.poll();
				//当前节点为空，直接进入下一次循环。
				if(curr == null) continue;
				//如果reverse为true，则需要向subList中反向添加元素。以满足锯齿形遍历的要求。
				if(reverse) {
					subList.addFirst(curr.val);
				}else{
					subList.addLast(curr.val);
				}
				if(curr.left != null) q.offer(curr.left);
				if(curr.right != null) q.offer(curr.right);
			}
			result.add(subList);
			//遍历完一层后，在进入下一层之前，修改reverse的值。达到奇偶交替的效果。
			reverse = !reverse;
		}
		return result;
	}
}
