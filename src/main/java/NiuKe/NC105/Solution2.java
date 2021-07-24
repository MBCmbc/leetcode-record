package NiuKe.NC105;

/*
在元素可能有重复的升序列中进行二分查找。
和普通二分查找不同的就是在nums[mid] == target的情况下要再进一步判断一下，当前mid是否就是target的最左边界，
如果不是则左移继续查找。
*/
public class Solution2 {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 *
	 * 如果目标值存在返回下标，否则返回 -1
	 * @param nums int整型一维数组
	 * @param target int整型
	 * @return int整型
	 */
	public int search (int[] nums, int target) {
		// write code here
		int left = 0, right = nums.length-1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] > target){
				right = mid - 1;
			} else if(nums[mid] < target){
				left = mid + 1;
			} else{ //nums[mid] == target    //要进一步探讨mid是否为target左边界
				if((mid==0) || (mid > 0 && nums[mid-1] != target)){    //1.是左边界
					return mid;
				} else{    //mid > 0 && nums[mid-1] == target)    //2.不是左边界
					right = mid - 1;
				}
			}
		}

		return -1;    //没找到
	}
}
