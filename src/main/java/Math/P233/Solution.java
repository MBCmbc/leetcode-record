package Math.P233;

/*
同剑指offer P43
大佬的思路+代码，思路确实很6，一般人想不出来。（“易得”那块，联系行李箱的密码锁就很好理解了）
https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/

时间复杂度：O(log10N)，因为每次循环都除以10，N为输入的数字n。                   打败100%
空间复杂度：O(1)，只用了几个变量。                                            打败64.4%
*/

class Solution {
	public int countDigitOne(int n) {
		int res = 0, high = n / 10, cur = n % 10, low = 0, digit = 1;
		while(high != 0 || cur != 0){
			if(cur == 0){
				res += high * digit;
			} else if(cur == 1){
				res += high * digit + low + 1;
			} else{
				res += (high + 1) * digit;
			}

			low += cur * digit;
			cur = high % 10;
			high /= 10;
			digit *= 10;
		}

		return res;
	}
}
