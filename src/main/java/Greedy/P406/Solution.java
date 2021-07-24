package Greedy.P406;

/*
官方题解，贪心算法。
思路：按h降序(1)，k升序(2)进行排序，再对排序后的数组从前往后遍历，把k作为index，将当前元素放到对应的index上，即可得到结果。具体原因看题解

时间复杂度：O(N*N)      打败76.65%
空间复杂度：O(N)        打败93.67%
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public int[][] reconstructQueue(int[][] people) {
		//按h升序，k降序排序
		Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2){
				return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
			}
		});

		//按index（即k）插入到输出队列
		List<int[]> output = new LinkedList<>();
		for(int[] p : people){
			output.add(p[1], p);
		}

		//转换为int[][]再输出
		int len = people.length;
		return output.toArray(new int[len][2]);
	}
}
