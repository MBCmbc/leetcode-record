package JzOffer.P59_1;

/*
同leetcode P239
自己的解法，在本题中通过了，但是在leetcode P239中的大数据输入测试用例上超时了。
很直接，从题目的描述出发，一个窗口一个窗口的计算最大值。但是有的窗口的最大值res[i]可以根据前一个窗口的最大值res[i-1]
推算出来。能用的就用，不能用的就遍历窗口内元素计算最大值。（类似于动态规划，但又不完全可以由前一个推出后一个）

时间复杂度：最坏情况下，序列为倒序，则每个窗口的最大值都要遍历计算得出，故为O(k(N-k+1))，k为窗口大小，N为数组长度。     打败92.21%
空间复杂度：O(1)，除了结果数组res外，只使用常数级别的额外空间。                                                        打败84.58%
*/

class Solution1 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];       //结果数组
		res[0] = nums[0];
		for(int i = 1; i < k; i++) res[0] = Math.max(res[0], nums[i]);  //初始化第一个窗口的最大值

		for(int i = 1; i < res.length; i++){
			if(nums[i -1] != res[i - 1]){       //窗口滑动后被“踢出”窗口的元素!=窗口最大值，则新的窗口最大值为（原窗口最大值，新进入元素）
				res[i] = Math.max(res[i-1], nums[i + k - 1]);           //中的较大者
			} else {                                //滑动窗口后被“踢出的”元素==窗口最大值
				if(nums[i+k-1] >= res[i-1]){        //若新元素>=“踢出元素/原最大值”，则新元素就是最大值。
					res[i] = nums[i+k-1];
				} else{                             //若新元素更小，则无法确定本窗口的最大值，重新遍历计算。
					res[i] = nums[i];
					for(int j = i + 1; j <= i+k-1; j++) res[i] = Math.max(res[i], nums[j]);
				}
			}
		}

		return res;
	}
}
