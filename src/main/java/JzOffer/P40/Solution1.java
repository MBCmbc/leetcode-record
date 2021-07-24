package JzOffer.P40;

/*
剑指offer思路1，官方题解方法三，快排思想。利用《小灰的算法之旅》快排单边循环法，实现。
https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
利用快排思想，以随机选定的数组中某个数pivot为分界线，比pivot小的都放左边，否则放右边。看左边的个数(包含pivot)是否为k个，是则返回，否则：
1. 个数小于k，在右边继续同样的递归，再找(k-num)个
2. 个数大于k，缩小边界，右边界设置为index(pivot)-1，在左边找k个。
因为快排是直接更改了数组内容，所以结束后返回数组前k个元素即可。

时间复杂度：O(N)，证明复杂，不会                                        打败83.19%
空间复杂度：O(logN)，递归调用的期望深度                                 打败73.29%
*/

import java.util.Random;

class Solution1 {
	public int[] getLeastNumbers(int[] arr, int k) {
		quickRecur(arr, 0, arr.length-1, k);
		int[] res = new int[k];
		for(int i = 0; i < k; i++) res[i] = arr[i];
		return res;
	}

	//快排的递归函数
	private void quickRecur(int[] arr, int left, int right, int k){
		if(left >= right) return;

		int pivotIndex = randomPartition(arr, left, right);     //分界元素的下标
		int num = pivotIndex - left + 1;    //左边共几个元素（包含pivot）
		if(num == k){       //等于所求，返回
			return;
		} else if(num < k){     //少于所求，在右边再找k-num个，凑够k个
			quickRecur(arr, pivotIndex+1, right, k-num);
		} else{     //多于所求，缩小右边界，在左边找k个
			quickRecur(arr, left, pivotIndex-1, k);
		}
	}

	//快排的分治移位函数（小在左，大在右），返回分界元素下标
	private int randomPartition(int[] arr, int left, int right){
		int randomIndex = new Random().nextInt(right - left + 1) + left;        //随机获取一个元素作为pivot元素
		int pivot = arr[randomIndex];
		swap(arr, left, randomIndex);       //把pivot交换至左边界，方便使用单边循环法
		int mark = left;        //mark表示比pivot小的所有元素的右边界

		for(int i = left + 1; i <= right; i++){    //循环遍历，把所有比pivot小的元素都移到左边
			if(arr[i] < pivot){
				++mark;
				swap(arr, mark, i);
			}
		}

		swap(arr, left, mark);      //交换pivot与mark，形成分支后的数组：小元素 -> pivot -> 大元素
		return mark;    //此时mark表示pivot下标
	}

	private void swap(int[] arr, int x, int y){
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}