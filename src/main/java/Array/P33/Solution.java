package Array.P33;

/*
刘启仁说这道题阿里笔试的时候考了，我就来看看。参考了大佬思路和代码。
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
思路：每次二分，mid都把搜索区间分为左右两部分：
    1.我们先看左半部分是否完全有序，若有序，则判断一下target是否在左半部分（有序才好判断，无序难判断），若在则right=mid-1深入搜索，不在则left=mid+1向右搜索。
    2.若左半部分无序，则右半部分必然有序。就先判断一下target是否在右半部分，若在则left=mid+1深入搜索，不在则right=mid-1向左搜索。

    搜索完都没找到，就返回-1.

时间复杂度：O(logN)，N为数组长度，二分查找时间复杂度。              打败100%
空间复杂度：O(1)。                                              打败97.99%
*/

class Solution {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return mid;
			}

			if(nums[mid] >= nums[left]){    //左半部分有序的情况
				if(target >= nums[left] && target < nums[mid]){ //判断target是否在左半部分（有序才好判断），在则深入搜索
					right = mid - 1;
				} else{                                         //不在则向右搜索
					left = mid + 1;
				}
			} else {    //左半部分无序，则右半部分必有序。
				if(target > nums[mid] && target <= nums[right]){    //判断target是否在右半部分，在则深入搜索，
					left = mid + 1;
				} else{                                             //不在则向左搜索。
					right = mid - 1;
				}

			}
		}

		return -1;      //没找到，返回-1.
	}
}
