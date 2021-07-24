package JzOffer.P44;

/*
同leetcode P400
剑指offer思路，+大佬题解。
https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
分为三步：
    1.确定n属于几位数，记为digit。（循环减去digit位数占的总位数count，直至n <=count）
    2.确定n属于digit位数的具体哪个值，记为num。（上一步减剩下的n，在这一步就代表从digit位的start开始，n是第几个数位）
    3.确定n在num中的第几位，取出并返回 。（对digit取余数即可得到）

时间复杂度：O(logN)，第一步最多循环logN次，第三步把num转为str(num)，需要O(logN)，故总计O(logN)。        打败100%
空间复杂度：O(logN)，把num转换为str(num)，需要O(logN)的额外空间。                                     打败79.04%
*/

class Solution {
	public int findNthDigit(int n) {
		int digit = 1;  //一个数字的位数
		long start = 1;  //digit位数的起始，1、10、100、1000
		long count = 9;  //digit位的数一共有多少个,加起来一共占据了多少数位
		while(n > count){   //1. 寻找n属于几位数的范围，即digit的值
			n -= count;
			++digit;
			start *= 10;
			count = start * digit * 9;
		}

		long num = start + (n - 1) / digit;  //2. 寻找n所属的是digit位的哪一个数字，num。
		return String.valueOf(num).charAt((n - 1) % digit) - '0';   //3. 找到n对应于num中的第几位，取出该值并返回
	}
}
