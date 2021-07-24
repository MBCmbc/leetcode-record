package NiuKe.NC88;

import java.util.*;

/*
和NC119，最小的k个数思路相同，不过这里是找最大的K个数，并且只需要返回第K个就好了。
*/
public class Solution {
	public int findKth(int[] a, int n, int K) {
		// write code here
		quickRecur(a, 0, n-1, K);
		return a[K-1];
	}

	public void quickRecur(int[] arr, int start, int end, int k){
		if(start >= end) return;

		int pivotIdx = partition(arr, start, end);
		int num = pivotIdx - start + 1;
		if(num == k){
			return;
		} else if(num > k){
			quickRecur(arr, start, pivotIdx - 1, k);
		} else{//num < k
			quickRecur(arr, pivotIdx+1, end, k-num);
		}
	}

	public int partition(int[] arr, int start, int end){
		int randomIdx = new Random().nextInt(end - start + 1) + start;
		swap(arr, start, randomIdx);
		int pivot = arr[start];
		int mark = start;

		for(int i = start+1; i <= end; i++){
			if(arr[i] > pivot){
				++mark;
				swap(arr, mark, i);
			}
		}

		swap(arr, start, mark);
		return mark;
	}

	public void swap(int[] arr, int x, int y){
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
