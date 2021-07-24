package DynamicProgramming.P338;

/*
自己写的无耻解法，没必要看。

利用java自带的函数Integer.bitCount()求出对应结果。

执行用时：打败74.42%
内存消耗：打败27.64%
*/

class Solution1 {
	public int[] countBits(int num) {
		int[] ans = new int[num+1];
		for(int i=0; i<=num; i++){
			ans[i] = Integer.bitCount(i);
		}

		return ans;
	}
}
