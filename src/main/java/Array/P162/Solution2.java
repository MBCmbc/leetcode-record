package Array.P162;

/*
官方题解，方法三。

利用二分法，分析如下：
1.如果nums[mid]>nums[mid+1]，说明在左半部分一定能找到一个峰值（要么mid本身是一个拐点，要么mid处于一个降序的中间部分，按Solution1的分析就继续往左找）；
2.否则，说明mid本身肯定不是峰值，而且在右半部分一定能找到一个峰值（要么mid+1是一个拐点，要么mid+1处于一个升序的中间部分，按Solution1的分析就继续往右找）。

二分法迭代至不满足l<r为止，所以最后l和r一定是相等的，返回哪个都可以。

时间复杂度：O(logN)     打败100%
空间复杂度：O(1)        打败70.07%
*/

class Solution2 {
	public int findPeakElement(int[] nums) {
		int l = 0, r = nums.length-1;
		while(l < r){
			int mid = (l+r)/2;
			if(nums[mid] > nums[mid+1]){
				r = mid;
			} else{
				l = mid+1;
			}
		}

		return l;
	}
}
