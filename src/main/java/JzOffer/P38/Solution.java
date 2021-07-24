package JzOffer.P38;

/*
剑指offer思路，+大佬题解。
https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
利用递归的思想，从字符串头部开始，每次固定一位（每个位置上的所有可能都遍历一次），直至最后一位被固定，就得到一种排列。

时间复杂度：O(N!)，若字符各不相同，有N*(N-1)*...*1种排列。                                                      打败91.59%
空间复杂度：O(N^2)，递归最深为N。但是set要保存的元素数为N+(N-1)+(N-2)+...+1 = N*(N-1)/2。                        打败21.59%
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
	private List<String> res = new LinkedList<>();
	private char[] c;
	public String[] permutation(String s) {
		if(s == null) return res.toArray(new String[res.size()]);
		c = s.toCharArray();
		recur(0);
		return res.toArray(new String[res.size()]);
	}

	private void recur(int x){  //x表示当前要确定字符内容的位置
		if(x == c.length - 1){
			res.add(String.valueOf(c));
			return;
		}

		HashSet<Character> set = new HashSet<>(); //c[x]这个位置目前为止都“来”过谁
		for(int i = x; i < c.length; i++){
			//之前这个位置已经用过这个元素了，再重复一遍得到的排列也都是和之前完全重复的，因为位置x后面包含的元素内容（不计顺序）都是一样的。
			//所以可以剪枝，去掉不必要计算。（而且题目也要求结果集里不要有重复元素）
			if(set.contains(c[i])) continue;
			set.add(c[i]);
			swap(x, i);         //交换一下，相当于位置x上的元素置为c[i]，后面的元素内容再进行排列
			recur(x + 1);
			swap(x, i);         //回溯，要保证字符数组恢复原样，以便下一轮循环的操作。
		}
	}

	private void swap(int x, int y){
		char tmp = c[x];
		c[x] = c[y];
		c[y] = tmp;
	}
}
