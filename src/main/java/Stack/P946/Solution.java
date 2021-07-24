package Stack.P946;

/*
同剑指offer，P31
剑指offer的思路，用一个辅助栈存储pushed元素。
顺序遍历popped元素，对于每一个popped元素，查看是否对应于栈顶元素：
                    1. 若对应，则栈顶元素出栈，判断下一个popped元素；
                    2. 不对应（栈为空或元素不等），则从pushed中取，直到找到所需元素。若pushed取完都没找到，说明序列不对应，返回false。

时间复杂度：O(N)，每个元素最多入栈与出栈各一次，故为O(2N)。                                 打败94.39%
空间复杂度：O(N)，最坏情况下，栈需要存储pushed序列内所有N个元素。                           打败89.12%
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque<Integer> stack = new ArrayDeque<>();
		//下一个将被压入辅助栈的pushed元素下标
		int index = 0;

		for(int i=0; i<popped.length; i++){
			//stack.isEmpty()的判断要放在前面，否则当stack为空，stack.peek()为null，null.equals()会出现空指针异常。
			while(stack.isEmpty() || !stack.peek().equals(popped[i])){
				//if条件对应于pushed元素取完的情况
				if(index >= pushed.length) return false;
				stack.push(pushed[index++]);
			}

			stack.pop();
		}

		//遍历完poped元素都没有返回false，说明两个序列对应上了，可以返回true。
		return true;
	}
}
