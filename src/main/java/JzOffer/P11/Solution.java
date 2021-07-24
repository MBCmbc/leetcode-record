package JzOffer.P11;

/*
数组中有递增序列，考虑二分查找的方法求解。剑指思路offer+题解实现代码。
https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/

时间复杂度：O(logN)，特殊情况下，若数组元素全相同，退化为O(N)。             打败100%
空间复杂度；O(1)。                                                      打败62.54%

*/

class Solution {
	public int minArray(int[] numbers) {
		int low = 0;
		int high = numbers.length-1;
		int mid;

		while(low < high){
			mid = (low+high) / 2;
			if(numbers[mid] > numbers[high]){
				//mid在左边的子序列中
				low = mid + 1;
			}else if(numbers[mid] < numbers[high]){
				//mid在右边的子序列中
				high = mid;
			}else{
				//numbers[mid] == numbers[high]，无法判断mid在哪个子序列，进行线性查找。
				int minVal = numbers[low];
				for(int i = low; i <= high; i++){
					minVal = Math.min(numbers[i], minVal);
				}
				return minVal;
			}
		}

		//当low==high时跳出二分查找的while循环，找到了结果，返回即可。
		return numbers[low];
	}
}
