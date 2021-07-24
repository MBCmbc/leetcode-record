package JzOffer.P62;

/*
大佬解法一，模拟链表。
https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
用一个ArrayList模拟链表（删除是在连续空间上的，比离散空间的LinkedList要快一些，不会超时），按题意进行循环删除，最后所剩即为所求。

时间复杂度：O(N*N)，N为输入n。ArrayList每删除一个元素需要O(N)时间复杂度，套在while循环内，就是O(N*N)。          打败19.9%
空间复杂度：O(N)，ArrayList大小。                                                                         打败28.78%
*/

import java.util.ArrayList;

class Solution1 {
	public int lastRemaining(int n, int m) {
		ArrayList<Integer> list = new ArrayList<>(n);
		for(int i = 0; i < n; i++) list.add(i);

		int idx = 0;
		while(n > 1){
			idx = (idx+m-1) % n;    //idx对应元素已删除，所以需要减1。对n取余是模拟循环链表中的圆圈
			list.remove(idx);
			--n;                    //数组大小减1
		}

		return list.get(0);
	}
}
