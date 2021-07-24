package NiuKe.NC48;

/*
在转动锅的有序数组中寻找目标值，同leetcode P33，搜索旋转排序数组。还是没写好。
基本思路：先判断m左半部分有序还是m右半部分有序想到了，但是进一步如何缩减区间还是没写好。
*/
public class Solution {
	/**
	 *
	 * @param A int整型一维数组
	 * @param target int整型
	 * @return int整型
	 */
	public int search (int[] A, int target) {
		// write code here
		int l = 0, r = A.length - 1;
		while(l <= r){
			int m = l + (r - l) / 2;
			if(A[m] == target) return m;

			if(A[m] >= A[l]){    //l~m部分有序        //注意一定是>=。因为可能有l==m的情况
				if(target >= A[l] && target < A[m]){    //判断一下target在不在有序区间
					r = m - 1;
				} else{
					l = m + 1;
				}
			} else {    //m~r部分有序
				if(target > A[m] && target <= A[r]){
					l = m + 1;
				} else{
					r = m - 1;
				}
			}
		}

		return -1;
	}
}
