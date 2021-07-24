package Array.P152;

/*
官方题解，方法一，动态规划；并考虑优化空间
代码：https://leetcode-cn.com/problems/maximum-product-subarray/solution/duo-chong-si-lu-qiu-jie-by-powcai-3/
思路二，动态规划

基本思路和《53.最大子序和》差不多，但关键问题在于乘法要考虑数组元素的正负号问题。
作为改进，这里除了维护preMax用来表示以前一个元素为结尾的子序列最大乘积外，还维护了preMin用于表示以前一个元素为结尾的子序列最小乘积。
如果当前元素为正数，自然想和preMax相乘以得到最大值；如果当前元素为负数，自然想和preMin相乘以得到最大值。然后再和nums[i]比较，取最大值。

为了更新preMax和preMin，在(nums[i], preMax*nums[i], preMin*nums[i])三者中，最大值就是以当前元素为结尾的子序列最大乘积currMax，
最小值就是以当前元素为结尾的子序列最小乘积currMin。在此轮循环行将结束时，currMax就是下一轮的preMax；currMin就是下一轮的preMin。

时间复杂度：一次循环遍历，O(N)                  执行用时：打败89.42%
空间复杂度：常数级别额外空间，O(1)              内存消耗：打败91.18%
*/

class Solution {
	public int maxProduct(int[] nums) {
		//从题目可以看出，数组不为空，不必考虑空数组的情况

		//以前一个元素为结尾的子序列乘积最大值
		int preMax=nums[0];
		//以前一个元素为结尾的子序列乘积最小值
		int preMin=nums[0];
		//最终结果
		int ans=nums[0];

		//以前当前元素为结尾的子序列乘积最大值、最小值。
		int currMax, currMin;
		//循环遍历
		for(int i=1; i<nums.length; i++){
			//(nums[i], preMax*nums[i], preMin*nums[i])三者中，最大值就是以当前元素为结尾的子序列乘积最大值
			currMax = Math.max(nums[i], Math.max(preMax*nums[i], preMin*nums[i]));
			//(nums[i], preMax*nums[i], preMin*nums[i])三者中，最小值就是以当前元素为结尾的子序列乘积最小值
			currMin = Math.min(nums[i], Math.min(preMax*nums[i], preMin*nums[i]));

            /*
            //另一种写法，直接分正负两种情况考虑，更直观一些。
            //https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
            //参考代码2
            if(nums[i]>=0){
            	//当前元素非负，正向考虑，乘preMax为大，乘preMin为小
                currMax = Math.max(nums[i]*preMax, nums[i]);
                currMin = Math.min(nums[i]*preMin, nums[i]);
            } else{
            	//当前元素为负，逆向考虑，乘preMax为小，乘preMin为大
                currMax = Math.max(nums[i]*preMin, nums[i]);
                currMin = Math.min(nums[i]*preMax, nums[i]);
            }
            */

			//根据结果与ans比较，继而更新ans
			ans = Math.max(currMax, ans);
			//更新preMax和preMin
			preMax = currMax;
			preMin = currMin;
		}

		return ans;
	}
}