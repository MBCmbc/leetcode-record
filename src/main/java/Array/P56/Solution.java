package Array.P56;

/*
https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
思路：先根据区间的起始位置排序，再进行n−1次两两合并。

时间复杂度：O(nlogn)，其中n为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的O(nlogn)。
空间复杂度：O(logn)，其中n为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
（可能是快排，快排的时间复杂度和空间复杂度正好对应上面的结果。）
（或者是按可能采用的各种不同排序方法的最坏情况计算的。）

执行用时：打败91.96%
内存消耗：打败73.12%
*/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int[][] merge(int[][] intervals) {
		//根据每个区间的起始位置大小，从小到大对intervals排序。
//		Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
		//第二种写法的执行速度稍快一些。
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

		//用于存储结果的二维数组，最坏情况下，其一维长度和intervals一样长，所以初始化时和intervals等长。
		int[][] result = new int[intervals.length][2];

		//用一个指针记录结果数组中当前已经填充到的位置。
		int index=-1;
		//遍历intervals
		for(int[] interval : intervals){
			//如果当前result仍为空，或者当前遍历到的区间与result最后一个区间没有任何重叠，
			//则将遍历到的区间添加到result的末尾。
			if(index==-1 || interval[0] > result[index][1]){
				result[++index] = interval;
			} else{
				//否则，说明区间有重叠，需要进行合并。
				result[index][1] = Math.max(result[index][1], interval[1]);
			}
		}
		//返回结果，因为从示例中可以看到返回结果是没有冗余的，需要考虑将result中未填充的（也就是空的）部分去掉。
		//Arrays.copOf()函数，用index+1表示要拷贝的长度，得到“无冗余”的的结果数组。
		return Arrays.copyOf(result, index+1);
	}
}
