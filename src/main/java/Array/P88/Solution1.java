package Array.P88;

/*
官方题解：解法一
思路：用系统函数，先合并，再排序。
时间复杂度 : 因为使用了Arrays.sort函数(int类型排序，内部采用算法是快排，时间复杂度O(nlogn))，所以为O((n+m)log(n+m))。   执行用时：打败23.45%
空间复杂度 : O(1)。                                                                                              内存消耗：打败5.06%

关于Arrays.sort()函数的时间复杂度解析：https://blog.csdn.net/lian47810925/article/details/4689323
*/

import java.util.Arrays;

class Solution1 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//把nums2数组合并到nums1后再排序
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
}
