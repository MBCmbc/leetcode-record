package JzOffer.P56_1;

/*
剑指offer思路，自己实现代码，与题解相同。
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
从左到右异或一次，得到的是两个要求数字的异或结果xor，因为二者不等，所以xor必有一位为1，且在这一位上，res[0]和res[1]中一个是1，一个是0。
据此，可以将原数组分为两组，一组在该位为1，另一组在该位为0。对这两组各自执行从左到右的异或，就能分别得到res[0]和res[1]。

时间复杂度：O(N)，N为数组元素个数，需要遍历两遍数组。               打败65.52%
空间复杂度：O(1)。                                                 打败85.83%
*/

class Solution2 {
	public int[] singleNumbers(int[] nums) {
		int[] res = new int[2];

		int xor = 0;                //第一遍按位异或
		for(int num : nums){
			xor ^= num;
		}

		int sig = 1;
		while((sig & xor) == 0) sig <<= 1;      //找到xor中为1的一位（任何一位为1的位都可以，从右到左找只是因为编码方便）

		for(int num : nums){
			if((sig & num) != 0){               //分组按位异或，得到结果。
				res[0] ^= num;
			} else{
				res[1] ^= num;
			}
		}

		return res;
	}
}
