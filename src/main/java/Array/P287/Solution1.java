package Array.P287;

/*
https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
二分法，参考代码1。
时间复杂度：O(NlogN)，二分法的时间复杂度为O(logN)，在二分法的内部，执行了一次for循环，时间复杂度为O(N)，故时间复杂度为O(NlogN)。
空间复杂度：O(1)，使用了一个 cnt 变量，因此空间复杂度为O(1)。
*/

class Solution1 {
	public int findDuplicate(int[] nums) {
		int len = nums.length;
		//二分法左边界初始化
		int left = 1;
		//二分法右边界初始化
		int right = len-1;

		//while循环进行二分查找
		while(left < right){
			int mid = (left+right) / 2;

			//计数器，计算数组中小于等于mid的数的个数
			int cnt = 0;
			for(int num : nums){
				if(num <= mid) ++cnt;
			}

			//根据结果更新left或right，为下一次while循环做准备。具体怎么去，可以画个数组试一试就知道了。
			if(cnt > mid){
				right = mid;
			} else{
				left = mid+1;
			}
		}

		//返回left或者right都可以，最终循环终止的时候二者一定是相等的。
		return right;
	}
}
