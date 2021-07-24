package Math.P69;

/*
官方题解，方法二，二分查找。
https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
思路，用二分法寻找k*k <= x的最大k值，即为所求。

时间复杂度：O(logX)，二分查找。         打败100%
空间复杂度：O(1)。                     打败71.09%
*/

class Solution {
	public int mySqrt(int x) {
		int l = 0, r = x;
		while(l <= r){
			int m = l + (r - l) / 2;
			long square = (long) m * m;     //可能溢出，所以转为long
			if(square == x){
				return m;
			} else if(square < x){
				l = m + 1;
			} else{
				r = m - 1;
			}
		}

		return r;
	}
}
