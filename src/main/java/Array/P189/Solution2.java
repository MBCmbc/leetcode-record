package Array.P189;

/*
官方题解，解法4：使用反转
思路：当我们rotate数组k次，k%n个尾部元素会被移动到头部，剩下的元素会被向后移动。
在这个方法中，我们首先将所有元素反转。然后反转前k个元素，再反转后面n-k个元素，就能得到想要的结果。
不理解的话，画个数组看一看就知道了。

时间复杂度：三次调用reverse函数，每次都是一个线性的while循环，故为O(N)；            执行用时：打败100%
空间复杂度：只用了常数级别的额外空间，故为O(1)。                                   内存消耗：打败7.14%
*/

class Solution2 {
	public void rotate(int[] nums, int k) {
		//k次与(k%nums.length)次的rotate效果是一样的。
		k = k % nums.length;

		//如思路中所言：先将所有元素反转，然后反转前k个元素，再反转后面n-k个元素。
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}

	//用于反转的工具函数
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}