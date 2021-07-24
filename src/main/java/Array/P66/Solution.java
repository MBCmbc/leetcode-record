package Array.P66;

/*
https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
思路非常棒，具体见代码中注释。
时间复杂度：最坏情况下需要遍历整个数组，故为O(N);                                                               执行用时：打败100%
空间复杂度：最坏情况下需要为digits新开辟(digits.length+1)的空间，但是这是用于返回结果的，不知道该怎么算。           内存消耗：打败5.63%
*/

class Solution {
	public int[] plusOne(int[] digits) {
		//因为加法是从个位开始加，所以从后向前遍历。
		for(int i = digits.length-1; i>=0; i--){
			//对当前遍历到的数加1后赋值为对10取余，有两种情况：
			//1.当前数字是9，加1后对10取余为0，需要进位，也就是给前一位数字加1，故进入下一次循环；
			//2.当前数字非9，加1后对10取余不为0，表示加1运算到此结束，直接返回当前数组即可。
			digits[i]++;
			digits[i] = digits[i] %10;
			if(digits[i] != 0) return digits;
		}

		//如果数组遍历完，i都为负了还没返回，只有一种情况：所有数字全是9，此时需要数组长度加1，并将首位置1，其余全为0
		//（数组初始化默认为0，故不用赋值了）
		digits = new int[digits.length+1];
		digits[0] = 1;
		return digits;
	}
}
