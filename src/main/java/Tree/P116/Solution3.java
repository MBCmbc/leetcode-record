package Tree.P116;

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
//解法二，利用已有的next指针
/*
时间复杂度：O(N)，每个节点只访问一次。
空间复杂度：O(1)，不需要存储额外的节点。
*/

class Solution3 {
	public Node connect(Node root) {
		//若树为空，直接返回
		if(root == null) return root;

		//树不为空，以根节点作为最初的leftMost（即某一层的最左边节点）
		Node leftMost = root;

		//若leftMost没有左孩子，说明目前是最后一层，本层的next指针已由上一层建立，无需再做操作。
		//每次都是在第N层建立第N+1层的next指针联系，所以最后一层无需操作。
		while(leftMost.left != null){
			//用curr存储层内遍历的当前节点
			Node curr = leftMost;

			while(curr != null){
				//如果curr是当前层的最后一个节点，只需将左孩子的next指针指向右孩子。
				if(curr.next == null){
					curr.left.next = curr.right;
				} else{
					//否则，除了将左孩子next指向右孩子，还要将右孩子的next指向下一个邻居的左孩子
					curr.left.next = curr.right;
					curr.right.next = curr.next.left;
				}

				//更新curr，准备进入下一次while循环
				curr = curr.next;
			}

			//更新leftMost为下一层的最左侧节点
			leftMost = leftMost.left;
		}

		return root;
	}
}
