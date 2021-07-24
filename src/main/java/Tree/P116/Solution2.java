package Tree.P116;

import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//官方题解
//解法一，BFS
//优化一下
class Solution2 {
	public Node connect(Node root) {
		//如果是空树，直接返回即可
		//if(root == null) return root;

		//创建用于BFS的队列
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		//bfs过程
		while(!q.isEmpty()){
			int size = q.size();

			for(int i=0; i<size; ++i){
				Node curr = q.poll();

				//如果节点为空,直接进入下次循环。主要是为了解决输入的树为空[]的情况.
				if(curr == null) continue;

				//如果不是一层的最后一个节点，next指针设置为下一个节点。
				//因为所有节点的初始next指针均指向null，所以该层最后一个节点无需再设置
				if(i < size-1) curr.next = q.peek();

				//如果左右孩子不为空，则入队。
				if(curr.left != null) q.offer(curr.left);
				if(curr.right != null) q.offer(curr.right);
			}
		}

		return root;
	}
}
