package JzOffer.P50;

/*
大佬题解，方法二。
https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
对于字符串内字符内容不确定的情况下，可以考虑使用有序哈希表LinkedHashMap（根据元素的插入顺序遍历），来统计每个字符出现的次数。
因为所求是只出现一次的字符，所以我们不必存储各字符出现的次数，只把出现了一次的标记为True，出现多次的标记为False即可。
第一次遍历字符串，标记各字符出现次数；
第二次遍历有序哈希表，找到第一个只出现一次的字符（第一个Value为True的key）

时间复杂度：O(N)，N为字符串长度。遍历字符串用时O(N)。哈希表的大小是有限的（只有字符集大小，若字符集为小写字母，则只有26），遍历用时为O(1)。             打败64.41%
空间复杂度：O(1)，只开辟了一个大小有限的有序哈希表。                                                                                            打败93.36%
*/

import java.util.LinkedHashMap;
import java.util.Map;

class Solution2 {
	public char firstUniqChar(String s) {
		Map<Character, Boolean> map = new LinkedHashMap<>();            //有序链表
		char[] chars = s.toCharArray();
		for(char ch : chars) map.put(ch, !map.containsKey(ch));         //有key说明出现过，标记为False，否则标记为True，表示目前为止只出现过一次
		for(char key : map.keySet()){
			if(map.get(key)) return key;                        //有序哈希表遍历顺序就是元素插入的顺序，所以第一个标记为True的字符，就是字符串中第一个只出现一次的字符。
		}
		return ' ';                                 //都标记为False，说明没有只出现一次的字符，返回空额。
	}
}
