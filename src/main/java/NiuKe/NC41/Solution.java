package NiuKe.NC41;

import java.util.*;

/*
最长不重复子字符串的长度，同剑指offer P48，动态规划。
*/
public class Solution {
	/**
	 *
	 * @param arr int整型一维数组 the array
	 * @return int整型
	 */
	public int maxLength (int[] arr) {
		// write code here
		HashMap<Integer, Integer> map = new HashMap<>();//记录某元素最近一次出现的位置。
		int res = 0;
		int dp = 0;
		for(int i = 0; i < arr.length; i++){
			if(!map.containsKey(arr[i])){
				++dp;
			} else{
                /*
                若当前元素之前出现过，又可以分为两种情况：
                    1.出现位置在“dp长度”覆盖范围以外，对当前的长度计算不影响，dp+1
                    2.出现位置在“dp长度”覆盖范围以内，长度需重新计算为与上一次出现位置之间的距离。
                */
				dp = i - map.get(arr[i]) > dp ? dp+1 : i - map.get(arr[i]);
			}

			res = Math.max(res, dp);
			map.put(arr[i], i);
		}

		return res;
	}
}
