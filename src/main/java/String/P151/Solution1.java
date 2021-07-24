package String.P151;

/*
同剑指offer P58-1
自己的解法,然后参考大佬题解中的“方法二：分割+倒序”对自己代码进行了优化。（面试时不建议使用）
https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
思路很直接，把字符串按空格分解为数组，然后倒序将其拼接即可。
连续空格的分割可以用"\\s+"，而不是" "，这样直接得到所有单词，但是速度会变慢。

时间复杂度：O(N)，具体分析可看大佬题解。                                      打败100%
空间复杂度：O(N)，单词列表splits[]占用线性大小的额外空间。                    打败96.2%
*/

class Solution1 {
	public String reverseWords(String s) {
		if(s == null) return null;
		String[] splits = s.trim().split(" ");          //先去除左右两边的空格，然后按空格划分字符串为数组
		StringBuilder res = new StringBuilder();
		for(int i = splits.length - 1; i >= 0; i--){//倒序拼接
			if(splits[i].equals("")) continue;          //1.字符串比较内容注意用equals()而不是==；2.连续空格split(" ")后，得到的是""，不是" "
			res.append(splits[i]).append(" ");
		}

		return res.toString().trim();       //最后会多一个空格，需要去除
	}
}
