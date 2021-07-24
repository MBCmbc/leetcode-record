package String.P14;

/*
官方题解，方法二，纵向扫描
https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
思路：取首个字符串strs[0]作为标准，从首个字符开始，一列一列的依次往后比较，如果某一列中，出现了后面strs[j]和strs[0]对应字符不相等或者遍历列的长度超过了strs[j]的情况，说明寻找结束，返回strs[0]的substring(0,i)子串即可。

时间复杂度：O(MN)，M为字符串平均长度，N为字符串数量，最坏情况下每个字符串的每个位置都要比较一下。       打败84.02%
空间复杂度：O(1)。                                                                              打败92.32%
*/
class Solution2 {
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";

		for(int i=0; i<strs[0].length(); i++){  //按列比较
			for(int j=1; j<strs.length; j++){   //与后面每个字符串比较
                /*
                情况1：列位置i超过了strs[j]的长度，寻找结束，返回。
                情况2：位置i处出现了不相等，寻找结束，返回。
                情况3：位置i相等，继续寻找。
                */
				if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
					return strs[0].substring(0, i);
				}
			}
		}

		//for循环结束都没返回，说明strs[0]本身就是最长公共前缀。
		return strs[0];
	}
}
