package JzOffer.P57_1;

/*
自己的思路，+代码实现。遍历+二分查找。
从左到右遍历数组，对遍历到的每一个元素nums[i]，在右边剩下的数组中用二分查找寻找target-nums[i]，找到即返回。

时间复杂度：O(NlogN)，N为数组长度，最坏情况下需要找遍整个数组。         打败22.21%
空间复杂度：O(1)。                                                     打败95.35%
*/

class Solution1 {
	private int[] nums;
	public int[] twoSum(int[] nums, int target) {
		this.nums = nums;
		for(int i = 0; i < nums.length; i++){                                       //遍历数组
			int index = binarySearch(i+1, nums.length - 1, target - nums[i]);       //查找 target - nums[i]
			if(index != -1) return new int[]{nums[i], nums[index]};                 //若找到则直接返回
		}

		return null;
	}

	int binarySearch(int start, int end, int target){       //二分查找，找到则返回元素下标，否则返回-1。
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(nums[mid] == target){
				return mid;
			} else if(nums[mid] > target){
				end = mid - 1;
			} else{     //nums[mid] < target
				start = mid + 1;
			}
		}

		return -1;
	}
}
