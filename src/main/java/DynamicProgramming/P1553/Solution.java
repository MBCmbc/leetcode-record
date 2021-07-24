package DynamicProgramming.P1553;

import java.util.HashMap;

/*
腾讯2021.3.22笔试题。
参考：https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/solution/java-3mssuan-fa-hashmapcun-chu-ji-suan-guo-de-zhi-/
以及官方题解：https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/solution/chi-diao-n-ge-ju-zi-de-zui-shao-tian-shu-by-leetco/
思路：无论怎样，n/2或者n/3应该会是最快的吃法，如果当前n无法被2或3整除，我们就1天吃1个，把n变成2或3的倍数，再吃。
     然而，n/2或n/3都有可能是最快的，因为n/2或n/3之后的数字发展是怎样的我们不知道，所以我们两者都计算一下，取较小者即可。

时间复杂度：O(logN * logN)，证明见官方题解      打败81.82%
空间复杂度：O(logN * logN)，证明见官方题解      打败45.45%
*/
class Solution {
	private HashMap<Integer, Integer> map = new HashMap<>();        //备忘录，记忆化搜索

	public int minDays(int n) {
		return recur(n);
	}

	public int recur(int n){
		if(n == 1) return 1;
		if(n == 2 || n == 3) return 2;
		if(map.containsKey(n)) return map.get(n);   //特殊值和已经计算过的值可以直接返回。

		int m2 = n%2 + 1 + recur(n/2);  //n%2天变成2的倍数，1天变成n/2，recur(n/2)天吃完。
		int m3 = n%3 + 1 + recur(n/3);  //n%3天变成3的倍数，1天变成n/3，recur(n/3)天吃完。
		int res = Math.min(m2, m3);     //取二者中较小者

		map.put(n, res);
		return res;             //放入备忘录并返回结果
	}
}
