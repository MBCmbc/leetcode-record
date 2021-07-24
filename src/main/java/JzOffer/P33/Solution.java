package JzOffer.P33;

/*
剑指offer的思路，自己用代码实现了。
根据后续遍历左、右、根的特点，以及二叉搜索树，左子树<根<右子树(题目假定节点值均互异)的特点，对于整树以及每一个子树序列，可以确定最后一个值是根，
然后根据与根的大小对比，可以确定左、右子树序列的边界。据此，利用递归对每棵子树判断是否满足二叉搜索树的大小关系，完成判断。

时间复杂度：O(N^2)，每次递归减去一个根节点，最坏情况下（链表），每次遍历（1、2、3、....N）个节点。故(1+2+3+...+N)          打败100%
空间复杂度：O(N)，最坏情况下，二叉树退化为链表，递归函数的调用栈最多同时有N层。                                           打败61.62%
*/

class Solution {
	private int[] postorder;
	public boolean verifyPostorder(int[] postorder) {
		if(postorder == null) return false;

		this.postorder = postorder;
		return isBinarySearchTree(0, postorder.length - 1);
	}

	//参数是树序列的开始和结束下标
	boolean isBinarySearchTree(int startIndex, int endIndex){
		//若子树有1或更少个节点，说明已经到了叶子，可以返回true
		if(startIndex >= endIndex) return true;

		int rootVal = postorder[endIndex];//根值
		//寻找右子树的起始下标
		int rightStart = startIndex;
		while(postorder[rightStart] < rootVal) ++rightStart;

		//前面寻找rightStart的过程，相当于确定了左子树，判断一下右子树里面的值是否都大于根，即可确定是否合乎要求。
		for(int i = rightStart; i < endIndex; i++){
			if(postorder[i] < rootVal) return false;
		}

		//本子树的左、右、跟序列的大小情况满足二叉搜索树要求，再递归判断左子树和右子树，直至叶子节点。
		return isBinarySearchTree(startIndex, rightStart-1) && isBinarySearchTree(rightStart, endIndex-1);
	}
}
