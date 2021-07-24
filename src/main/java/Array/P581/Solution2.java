package Array.P581;

/*
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/shi-jian-chao-guo-100de-javajie-fa-by-zackqf/
*/

class Solution2 {
	public int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		int max = nums[0];
		int min = nums[len-1];
		int l=0, r=-1;
		//同时从前往后和从后往前遍历，分别得到要排序数组的右边界和左边界；
		for(int i=0; i<len; i++){
            /*
            寻找右边界：
            从前往后遍历的过程中，用max记录遍历过的最大值，如果max大于当前的nums[i]，说明nums[i]的位置不正确，属于需要排序的数组，
            因此将右边界更新为i，然后更新max；这样最终可以找到需要排序的数组的右边界，右边界之后的元素都大于max；
            */
			if(max > nums[i]){
				r = i;
			} else{
				max = nums[i];
			}


            /*
            寻找左边界：
            从后往前遍历的过程中，用min记录遍历过的最小值，如果min小于当前的nums[j]，说明nums[j]的位置不正确，应该属于需要排序的数组，
            因此将左边界更新为j，然后更新min；这样最终可以找到需要排序的数组的左边界，左边界之前的元素都小于min；
            */
			//从前往后遍历和从后往前遍历两个过程可以分两次循环完成，也可以放一起完成，这样的话就有：j=len-i-1
			if(min < nums[len-1-i]){
				l = len-1-i;
			} else{
				min = nums[len-1-i];
			}
		}

		//若数组本身有序，则l=0和r=-1会维持初始值不变，这样用下面的式子就能得到0；
		//若有更新，则用下面的式子可以计算出正确的长度。
		return r-l+1;
	}
}
