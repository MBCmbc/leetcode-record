package DynamicProgramming.P300;

/*
https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
解法二：动态规划+二分查找（其实说他是贪心更合适）
具体思路有些复杂，看题解吧。

时间复杂度：O(n*logn)，外循环n，内循环二分法为logn          打败90.21%
空间复杂度：O(n)，tails数组                               打败87.38%
*/

class Solution2 {
	public int lengthOfLIS(int[] nums) {
		//每个元素tails[k]的值代表长度为k+1的子序列尾部元素的值
		int[] tails = new int[nums.length];
		int result = 0;
		for(int num: nums){
			int left = 0, right = result;
			//二分法寻找第一个满足tails[i]>num的数：1.若有这样的数则执行tails[i]=nums；2.否则将num接到tails的末尾
			while(left < right){
				int mid = (left+right)/2;
				if(tails[mid] < num){
					left = mid+1;
				}else{
					right = mid;
				}
			}
			//二分法到最后一定是left==right的。而且若是情况1，则left==right==要找的i；若是情况2，则left==right==tails末尾下标
			//所以不管怎样，执行tails[left] = num;即可。
			tails[left] = num;
			//若二分查找结束后right(或left)仍与result相等，说明right根本没变化过，所有tails[i]<num，也就是第二种情况，需要将result加1。
			if(right == result) result++;
		}

		return result;
	}
}
