package Array.P55;

/*
官方题解，方法一，贪心。
https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/

思路：对数组进行一次遍历，维护并实时更新一个变量，用于存储跳跃所能到达的最远位置。如果最远位置超过了数组的最后一个位置，就说明末位可达；相反，如果遍历完后最远位置都达不到数组末位，则返回false。

时间复杂度：遍历一次数组，故为O(N)                              执行用时：打败78.77%
空间复杂度：使用了常数级别的空间，故为O(1)                       内存消耗：打败95.23%
*/

class Solution {
	public boolean canJump(int[] nums) {
		//数组长度，也用来标记最后一位的位置
		int n = nums.length;
		//跳跃最远可达位置
		int rightMost = 0;
		//遍历数组
		for(int i=0; i<n; i++){
			//遍历到的位置仍在可达范围内，需要根据当前位置的值跟进更新最远可达位置
			if(i <= rightMost){
				rightMost = Math.max(rightMost, i+nums[i]);
				if(rightMost >= n-1) return true;
			} else{
				//如果遍历到的位置已经超过了最远可达位置，而这时数组还没遍历完或刚好遍历到最后一位，
				//这说明目前的位置都无法跳跃到，数组的最后一位也必定无法跳到。
				return false;
			}
		}
		//数组遍历完都没有返回true，说明肯定是无法到达最后一位了，返回false即可。
		return false;
	}
}
