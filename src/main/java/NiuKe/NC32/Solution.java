package NiuKe.NC32;

/*
求平方根，同leetcode P69。使用二分查找寻找满足k * k <= x的最大k值。
*/
public class Solution {
	/**
	 *
	 * @param x int整型
	 * @return int整型
	 */
	public int sqrt (int x) {
		// write code here
		int l = 0, r = x;
		while(l <= r){
			int m = l + (r - l) / 2;
			if((long) m*m == x){
				return m;
			} else if ((long) m*m < x){
				l = m + 1;
			} else {
				r = m-1;
			}
		}

		return r;
	}
}
