package NiuKe.NC128;

/*
表示高度的数组构成一个容器，问最多能盛多少水，同leetcode P42.
*/
public class Solution {
	/**
	 * max water
	 *
	 * @param arr int整型一维数组 the array
	 * @return long长整型
	 */
	public long maxWater(int[] arr) {
		// write code here
		long sum = 0;    //SB题目，不说清楚；最终水的数量可能很大，造成溢出，所以用long来存储。
		if (arr == null || arr.length == 0) return sum;
		int len = arr.length;
		int left = 1, right = len - 2;
		int maxLeft = arr[0], maxRight = arr[len - 1];

		while (left <= right) {
			if (maxLeft < maxRight) {
				sum += arr[left] < maxLeft ? (maxLeft - arr[left]) : 0;
				maxLeft = Math.max(arr[left], maxLeft);
				++left;
			} else {
				sum += arr[right] < maxRight ? (maxRight - arr[right]) : 0;
				maxRight = Math.max(maxRight, arr[right]);
				--right;
			}
		}

		return sum;
	}
}