package Array.P581;

/*
官方题解：方法5
*/

class Solution1 {
	public int findUnsortedSubarray(int[] nums) {
		//初始化乱序序列中的最小值和最大值
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=1; i<nums.length; i++){
			//找到乱序开始的点(除了第一次乱序开始的点，在后面可能还会有这样的点，不过无所谓了，flag已经为true了，后续没什么影响)
			if(nums[i-1] > nums[i]) flag = true;
			//不停更新min的值，找到乱序子序列中的最小值
			if(flag) min = Math.min(min, nums[i]);
		}

		//同理，找到乱序子序列中的最大值
		flag= false;
		for(int i= nums.length-2; i>=0; i--){
			if(nums[i+1] < nums[i]) flag = true;
			if(flag) max = Math.max(max, nums[i]);
		}

		int l,r;
		//从左到右遍历，找到首个大于min的点，作为最短无序子序列的起点
		for(l=0; l<nums.length; l++){
			if(nums[l] > min) break;
		}

		//同理，从右到左遍历，找到首个小于max的点，作为最短无序子序列的终点
		for(r=nums.length-1; r>=0; r--){
			if(nums[r] < max) break;
		}

		//如果r-l小于0，说明数组本身是从小到大排序的，最短无序连续子数组长度为0。
		return (r-l)<0 ? 0 : r-l+1;
	}
}
