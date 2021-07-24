package NiuKe.NC54;

import java.util.*;
/*
在数组中寻找和为0的三元组，且要从小到大排列，无重复。
参考：https://blog.nowcoder.net/n/d38ab3833b7d4c6da75d99366b1808d1
思路：先对数组排序，然后用双指针法。先确定三元组的第一个元素num[i]，然后用双指针j和k从剩余数组的两端向中间寻找和为-nums[i]的二元组，
     因为排好序了，所以一次移动一个指针，很方便寻找。
注意：需要去重。

时间复杂度：相比于暴力的O(N^3),此方法优化至O(N^2)。（排序为O(NlogN)）
空间复杂度：O(1)，只有一个结果ArrayList。
*/
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(num == null || num.length < 3) return res;
		Arrays.sort(num);
		for(int i = 0; i < num.length-2 && num[i] <= 0; i++){
			int j = i+1, k = num.length-1;
			int target = -num[i];
			while(j < k && num[k] >= 0){
				if(num[j] + num[k] > target) k--;
				else if(num[j] + num[k] < target) j++;
				else{
					ArrayList<Integer> subRes = new ArrayList<>();
					subRes.add(num[i]);
					subRes.add(num[j]);
					subRes.add(num[k]);
					res.add(subRes);
					while(j < k && num[j]==num[j+1]) j++;   //防止重复
					while(j < k && num[k]==num[k-1]) k--;   //防止重复
					j++;
					k--;
				}
			}
			while(i < num.length - 2 && num[i] == num[i+1]) i++;   //防止重复
		}
		return res;
	}
}