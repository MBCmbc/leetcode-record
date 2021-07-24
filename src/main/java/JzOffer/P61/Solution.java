package JzOffer.P61;

import java.util.Arrays;

/*
剑指offer的思路，又参考了一下大佬的代码，自己实现。
https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
大体思路可以分为以下三步：
    1.数组排序，保持从小到大。
    2.遍历统计数组中0（joker）的个数，以及数字间的间隙（gap）个数（一个间隙可以用一个0来填补）。
    3.若gap<=joker，说明0的个数足以填补gap（小于的话可以把0放在两端），返回true，否则false。
    特殊情况：若数组中有重复元素，则必不是顺子，返回false。（0重复不算，大小王总共可以有两个，并且可以作为任意数）

时间复杂度：排序复杂度=O(NlogN)=O(5log5)=O(1)，for循环复杂度=O(4)=O(1)。总计O(1)        打败90.72%
空间复杂度：O(1)。                                                                   打败14.88%
*/

class Solution {
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int joker = 0, gap = 0;         //joker表示大小王(0)的个数，gap表示间隙的个数。
		for(int i = 0; i < 4; i++){
			if(nums[i] == 0) ++joker;   //统计joker个数（因为joker最多2个，所以排序后，前4个肯定完全包含了。）
			else if(nums[i] == nums[i+1]) return false;     //出现0以外的重复元素
			else gap += nums[i+1] - nums[i] -1;     //统计间隙个数
		}

		return gap <= joker;    //判断是否为顺子
	}
}
