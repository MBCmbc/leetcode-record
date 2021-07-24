package Array.P41;

/*
官方题解，方法二,置换。

思路：
1. 首先对数组内元素位置进行调换，使得nums[x-1]上的元素为x；
    调换方法：1.1 遍历数组，对于遍历到的元素nums[i]=x，若在[1,n]之间，就与nums[x-1]上的元素互换，这样x就出现在了正确的位置；
             1.2 对于位置i，置换过来的元素可能仍在[1,n]之间，那就继续置换，直到不满足要求为止。
             1.3 特殊情况，nums[i]==nums[x-1]，会陷入死循环，需要排除这种情况。
2. 从左到右遍历，第一个不满足nums[x-1]==x的位置就是要找的数。

时间复杂度：O(N)，每次的交换操作都会使得某一个数交换到正确的位置，因此交换的次数最多为N。       打败88.10%
空间复杂度：O(1)                                                                        打败86.11%
*/

class Solution2 {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

        /*
            第一步，对数组内元素位置进行调换，使得nums[x-1]上的元素为x：
            调换方法：1.1 遍历数组，对于遍历到的元素nums[i]=x，若在[1,n]之间，就与nums[x-1]上的元素互换，这样x就出现在了正确的位置；
                     1.2 对于位置i，置换过来的元素可能仍在[1,n]之间，那就继续置换，直到不满足要求为止。
                     1.3 特殊情况，nums[i]==nums[x-1]，会陷入死循环，需要排除这种情况。
        */
		for(int i=0; i<n; i++){
			while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1] != nums[i]){
				int temp = nums[nums[i] -1];
				nums[nums[i]-1] = nums[i];
				nums[i] = temp;
			}
		}

		//第二步，从左到右遍历，第一个不满足nums[x-1]==x的位置就是要找的数。
		for(int i=0; i<n; i++){
			if(nums[i] != i+1) return i+1;
		}

		//如果全都满足nums[x-1]==x，说明就数组内的n个数正好是[1,n]，返回n+1即可。
		return n+1;
	}
}
