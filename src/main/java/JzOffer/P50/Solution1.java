package JzOffer.P50;

/*
自己的想法实现了，但是代码写的不好，有点复杂，参考了题解评论区一位大佬的代码，很简洁。@紫雾凌寒 2020-10-20
题解用的是哈希表，因为题目说明了只有小写字母，所以用数组可能更好一些。
https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
先遍历一遍字符串，用数组记录下每个字母出现的次数；
再遍历一遍字符串，同时比对数组中记录的字母出现次数，第一个出现次数为1的字母，即为所求。

若字符集不是小写字母，而是更多的话，可以根据字符大小开辟一个更大的数组来存储出现次数。

时间复杂度：O(N)，N为字符串s的长度，遍历了两次              打败99.18%
空间复杂度：O(1)，额外数组大小固定为26                     打败59.2%
*/

class Solution1 {
	public char firstUniqChar(String s) {
		int[] arr = new int[26];                //记录各字母出现次数的数组
		char[] chars = s.toCharArray();
		for(char ch : chars) arr[ch - 'a']++;   //字母对应的数组元素+1

		for(char ch : chars){
			if(arr[ch-'a'] == 1) return ch;     //返回首个只出现一次的字母
		}

		return ' ';                             //没有只出现一次的，返回空格。
	}
}
