package NiuKe.NC105;

/*
二分查找。自己实现。
 */
public class Solution {
	/**
	 * 二分查找
	 * @param n int整型 数组长度
	 * @param v int整型 查找值
	 * @param a int整型一维数组 有序数组
	 * @return int整型
	 */
	public int upper_bound_ (int n, int v, int[] a) {
		// write code here
		if(a[n-1] < v) return n+1;    //不存在的情况

		int left = 0, right = n-1;
		while(left < right){
			int mid = left + (right -left) / 2;
			if(a[mid] < v){
				left = mid + 1;
			} else{ //a[mid] >= v
				right = mid;
			}
		}
		//while循环终止时，left==right，随便返回哪个都可以。
		return left+1;//因为从1开始计数，所以+1。
	}
}
