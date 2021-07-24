package JzOffer.P56_2;

/*
剑指offer思路，自己实现代码。
对于数组内的所有数字，统计第0~31各个位上，1出现的总次数。因为除所求之外，其他数字都出现了三次，所以在最终统计结果count中，
若count[i]%3 != 0，说明res在该位为1，否则说明res在该位为0，据此规律构造出res即可。

时间复杂度：O(N)，N为数组长度，需要遍历一遍数组。           打败49.61%
空间复杂度：O(1)，count[]长度为固定32，常数级别。           打败44.13%
*/

class Solution {
	public int singleNumber(int[] nums) {
		int[] count = new int[32];          //统计各位上1出现的次数
		int res = 0;

		for(int num : nums){                //遍历统计每个数字
			int sig = 1;
			for(int i = 0; i < 32; i++){                //统计每个数字的各bit位
				if((sig & num) != 0) count[i]++;        //该位不为0，count对应位统计+1
				sig <<= 1;                              //左移，统计该数字的下一bit位
			}
		}

		for(int i = 0; i < 32; i++){
			if((count[i] % 3) != 0) res |= (1 << i);    //res该位不为0，置为1。
		}

		return res;
	}
}
