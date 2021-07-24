package JzOffer.P03;

/*
思路二，原地置换，将数组元素m放到位置m上去，也是剑指Offer上提供的解法。
https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/

时间复杂度：O(N)，虽然代码中有一个两重循环，但每个数字最多只需要交换两次就可以找到属于自己的位置。              打败100%
空间复杂度：O(1)，所有操作均在均在输入数组上进行，不需要额外分配内存。                                      打败91.7%
*/

class Solution2 {
	public int findRepeatNumber(int[] nums) {
		int temp;
		//遍历数组
		for(int i=0; i<nums.length; i++){
			//交换元素位置直到本位置元素和下标对应，或找到重复元素
			while(nums[i] != i){
				//找到重复元素
				if(nums[nums[i]] == nums[i]){
					return nums[i];
				}

				//交换元素位置，将当前nums[i]放到本该在的位置
				temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}

		//数组遍历完都没找到重复元素，返回-1.
		return -1;
	}
}
