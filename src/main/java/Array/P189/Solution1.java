package Array.P189;

/*
自己的解法，第一次尝试。
思路：手动进行k次rotate操作，每次rotate以遍历的方式挨个移动数组元素，但是性能较差。

时间复杂度：O((k % nums.length)*nums.length)        执行用时：打败31.26%
空间复杂度：O(1)                                    内存消耗：打败7.14%
*/

class Solution1 {
	public void rotate(int[] nums, int k) {
		//k大小超过nums.length后，移动k次和移动(k % nums.length)次效果是一样的。
		k = k % nums.length;

		//变量tmp用于存储数组最后一次，以便后面赋值给nums[0]
		int tmp;
		//第一层for循环，代表k次移动
		for(int i=0; i<k; i++){
			//由于数组最后一位会被覆盖，所以提前用tmp存储，之后再赋值给nums[0]
			tmp = nums[nums.length-1];
			//第二层循环，代表一次移动中的具体数字右移。
			for(int j=nums.length-1; j>0; j--){
				nums[j] = nums[j-1];
			}
			//根据rotate规则，nums[0]更新为原数组的最后一位。
			nums[0] = tmp;
		}
	}
}
