package JzOffer.P53_2;

/*
自己的解法，因为数组是排序的，所以首先想到二分查找。
数组可以看作两部分：左边nums[i] == i，右边nums[i] > i，根据这个特点，进行二分查找。

时间复杂度：O(logN)，二分查找。             打败100%
空间复杂度：O(1)。                          打败62.41%
*/
class Solution {
	public int missingNumber(int[] nums) {
		int left = 0, right = nums.length - 1;
		while(left <= right){   //right取为nums.length - 1，必须用<=，否则数组只有一个元素时将不会进入循环。
			int mid = left + (right - left) / 2;
			if(nums[mid] == mid){   //mid目前处于左边子序列，往右边查找
				left = mid + 1;
			} else{ //nums[mid] > mid      //因为是缺失了一个数，所以元素必定>=下标     //目前处于右边子序列
				if(mid == 0 || nums[mid-1] == mid - 1){     //nums[mid] > mid时，有两种情况是可以返回的：
					return mid;                           //1.缺失0，nums[0] == 1；2.目前mid就是右边序列的左边界，即nums[i] == i+1的第一个，所缺即为mid。两种情况均直接返回mid即可。
				} else{
					right = mid - 1;        //mid左边仍有nums[i]>i，说明左边界还在更左边，往左继续查找。
				}
			}
		}

		return nums.length;     //在数组内部没有找到这个边界，只可能有一种情况：缺失的是n-1，即nums.length。
	}
}
