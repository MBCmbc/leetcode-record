package JzOffer.P53_1;

/*
同leetcode P34，返回值不同罢了。
剑指offer思路，自己实现代码。
因为是有序数组，所以寻找target的个数就是寻找target元素在数组内的左边界和右边界。对于有序数组，
我们可以用二分查找的方法找到左边界和右边界。

时间复杂度：O(logN)，二分查找。             打败100%
空间复杂度：O(1)。                          打败82.21%
*/

class Solution2 {
	public int search(int[] nums, int target) {
		int x = 0, y = nums.length - 1;
		int left = -1, right = -1;
		//查找右边界
		while(x <= y){  //y为nums.length-1的时候，必须带上=号，不然数组只有一个元素时将不会进入while循环
			int mid = x + (y - x) /  2;
			if(nums[mid] > target){     //所求在左边
				y = mid - 1;
			} else if(nums[mid] < target){  //所求在右边
				x = mid + 1;
			} else{ //nums[mid] == target
				if(mid == nums.length - 1 || nums[mid+1] > target){     //1.mid在数组末尾的情况；2.mid右边元素大于target的情况。可以确定mid就是右边界
					right = mid;
					break;
				} else{ //nums[mid+1] == target         //因为升序，nums[mid+1]若不大于target，则必定=target；则右边界还在右边。
					x = mid + 1;
				}
			}
		}

		if(right == -1) return 0;       //右边界没变，说明没有target元素，直接返回0即可。

		x = 0;
		y = right;          //若有target元素，则x置0，y置右边界，继续查找左边界
		while(x <= y){
			int mid = x + (y - x) / 2;
			if(nums[mid] > target){
				y = mid - 1;
			} else if(nums[mid] < target){
				x = mid + 1;
			} else{ //nums[mid] == target
				if(mid == 0 || nums[mid - 1] < target){
					left = mid;
					break;
				} else{ //nums[mid - 1] == target
					y = mid - 1;
				}
			}
		}

		return right - left + 1;        //左右边界之差即为target个数。
	}
}
