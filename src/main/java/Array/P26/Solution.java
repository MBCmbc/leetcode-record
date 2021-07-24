package Array.P26;

/*
邱玉康说字节面试的时候考了这道题，我来看看。
思路：双指针法，left指针记录所有不重复元素的右边界，right指针往右搜索，直到找到不重复的元素位置，覆写到left后一位。
    while循环结束后，left所在位置就是所有不重复元素右边界，返回left+1即可。

时间复杂度：O(N)，一次遍历，N为nums数组长度。               打败100%
空间复杂度：O(1)。                                        打败76.58%
*/
class Solution {
	public int removeDuplicates(int[] nums) {
		int left = 0, right = 1;
		while(right < nums.length){
			if(nums[left] == nums[right]) right++;  //left和right所指重复，看right下一位。
			else nums[++left] = nums[right++];      //元素不重复，覆写到left后一位，并且right继续向右搜索。
		}

		return left + 1;    //边界值即为长度。
	}
}
