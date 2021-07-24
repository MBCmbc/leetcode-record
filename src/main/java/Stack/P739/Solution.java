package Stack.P739;

/*
官方题解，方法二，单调栈。
思路：维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。

时间复杂度：O(N)。其中N是温度列表的长度。正向遍历温度列表一遍，对于温度列表中的每个下标，最多有一次进栈和出栈的操作。           打败82.81%
空间复杂度：O(N)。其中N是温度列表的长度。需要维护一个单调栈存储温度列表中的下标。                                               打败40.83%
*/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public int[] dailyTemperatures(int[] T) {
		int len = T.length;
		//结果数组
		int[] ans = new int[len];
		//存储下标的栈
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i=0; i<len; ++i){
			//当前遍历到的温度
			int temperature = T[i];
			//当栈非空且栈顶温度小于当前温度，说明栈顶下标对应的日期找到了第一个比自己高的温度，可以将该元素出栈了。且该下标对应答案（即需要等待的天数），就是当前遍历到的下标i减去该下标
			while(!stack.isEmpty() && temperature > T[stack.peek()]){
				int preIndex = stack.pop();
				ans[preIndex] = i - preIndex;
			}
			///所有比T[i]小的元素都出栈后，i就需要进栈了，后续将为i寻找第一个温度更高的日期。
			stack.push(i);
		}
		//ans数组未在遍历中被赋值的元素，将保持为初始化状态下的0，即表示气温在这之后都不会升高至超过此值，这与题目要求一致，故直接返回ans即可。
		return ans;
	}
}
