package BitManipulation.P191;

/*
官方题解，方法一，循环和位移动。
    思路：使用第i位为1，其他全为0的掩码与输入按位与，若结果不为0，则说明输入的第i位为1，将结果bits加1；
          不断循环移动掩码中1的位置，遍历一次结束后即可得到结果。

时间复杂度：O(1),运行时间依赖于数字n的位数。由于这题中n是一个32位数，所以运行时间是 O(1)    打败98.98%
空间复杂度：O(1)                                                                           打败97.87%
*/

public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for(int i=0; i<32; i++){
			if((n&mask) != 0) bits++;
			mask <<= 1;
		}

		return bits;
	}
}
