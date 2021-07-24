package JzOffer.P15;

/*
剑指offer常规解法，用一个只有1位为1的标志位，从最右边开始，每次左移一位并和输入按位与，与的结果为1则说明该位为1。
    因为输入是int，flag也是int，所以位移正好匹配。

时间复杂度：O(1)，因为是int，所以可以确定左移32次之后while循环就停止了，常数时间复杂度。                打败97.28%
空间复杂度：O(1)                                                                                 打败78.75%
*/

public class Solution1 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int res = 0;
		int flag = 1;
		while(flag != 0){
			if((flag & n) != 0) res++;
			flag <<= 1;
		}

		return res;
	}
}
