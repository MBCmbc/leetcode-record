package NiuKe.NC119;

import java.util.ArrayList;
import java.util.Random;

/*
同剑指offer P40 Solution1
*/
public class Solution1 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (k == 0 || k > input.length) return res;
		quickRecur(input, 0, input.length - 1, k);
		for (int i = 0; i < k; i++) res.add(input[i]);
		return res;
	}

	public void quickRecur(int[] arr, int start, int end, int k) {
		if (start >= end) return;

		int pivotIndex = partition(arr, start, end);
		int nums = pivotIndex - start + 1;
		if (nums == k) {
			return;
		} else if (nums > k) {
			quickRecur(arr, start, pivotIndex - 1, k);
		} else {    //nums < k
			quickRecur(arr, pivotIndex + 1, end, k - nums);
		}
	}

	public int partition(int[] arr, int start, int end) {
		int randomIdx = new Random().nextInt(end - start + 1) + start;
		swap(arr, start, randomIdx);
		int pivot = arr[start];
		int mark = start;

		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < pivot) {
				++mark;
				swap(arr, mark, i);
			}
		}

		swap(arr, start, mark);
		return mark;
	}

	public void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
