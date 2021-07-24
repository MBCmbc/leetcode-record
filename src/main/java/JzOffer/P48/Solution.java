package JzOffer.P48;

/*
同leetcode P03
剑指offer思路，+自己实现代码。
动态规划+哈希表的解法。用哈希表存储每个字符最后一次出现的位置。用f(i)表示以第i位字符为结尾的字符串，最长不重复的长度（往前数）。则有以下情况：
C(i)表示第i位字符，I(C(i))表示C(i)最后一次出现的位置。
1. C(i)未出现过，则f(i) = f(i-1) + 1;
2. C(i)出现过，用d表示i - I(C(i)) ，即C(i)距上一次自己出现的距离，则又分为以下情况：
    2.1. d > f(i-1)，则f(i-1)对应的最长子串里没有C(i)，可以直接把C(i)加到该子串末尾，则f(i)=f(i-1)+1
    2.1. d <= f(i-1)，C(i)在f(i-1)对应的最长子串里出现过，需要从I(C(i))之后开始，到C(i)为止，形成新的最长子串，此时f(i)=d

时间复杂度：O(N)，N为字符串长度，遍历一次字符串。                                                       打败80.87%
空间复杂度：O(1)，字符的ASCII标的范围是0~127，哈希表最多使用O(128) = O(1)的额外空间。                    打败39.16%
*/

import java.util.HashMap;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int dp = 0, res = 0;    //dp表示f(i)，因为只与f(i-1)有关，所以只用一个变量进行迭代更新即可
		HashMap<Character, Integer> map = new HashMap<>();  //存储每个字符最后一次出现为止的哈希表
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){    //字符未出现过
				++dp;
			} else{     //字符出现过
				dp = i - map.get(c) > dp ? dp+1 : i - map.get(c);
			}
			res = Math.max(res, dp);    //res，即结果变量，需要取所有f(i)中的最大值
			map.put(c, i);      //更新本字符最后一次出现的位置
		}

		return res;
	}
}
