package JzOffer.P45;

/*
剑指offer思路，+大佬题解
https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
定义一种特殊的比较器，对两个以数字为内容的字符串s1和s2，若s1+s2 < s2+s1，则认为s1更小。用这样的比较器对数组进行排序，根据可证明的传递性，
排序后的数组依次拼接就是要求的数字字符串。（证明过程些许复杂，需要掌握）

时间复杂度：O(NlogN)，内置快排的时间复杂度。                    打败77.8%
空间复杂度：O(N)，字符串数组。                                 打败61.41%
*/

import java.util.Arrays;

class Solution {
	public String minNumber(int[] nums) {
		String[] s = new String[nums.length];
		for(int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
		Arrays.sort(s, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length; i++){
			sb.append(s[i]);
		}

		return sb.toString();
	}
}