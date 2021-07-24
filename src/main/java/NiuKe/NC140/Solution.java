package NiuKe.NC140;

/*
数组排序
 */
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 将给定数组排序
	 * @param arr int整型一维数组 待排序的数组
	 * @return int整型一维数组
	 */
	public int[] MySort (int[] arr) {
		// write code here
        /*库函数
        Arrays.sort(arr);
        */

        /*冒泡，超时。
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        */

        /*
        优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) queue.offer(arr[i]);
        for(int i = 0; i < arr.length; i++) arr[i] = queue.poll();
        */

		//快排
		quicksort(arr, 0, arr.length-1);

		return arr;
	}

	//快排实现
	public void quicksort(int[] arr, int start, int end){
		if(start >= end) return;

		int pivotIndex = partition(arr, start, end);    //得到基准元素位置
		quicksort(arr, start, pivotIndex-1);
		quicksort(arr, pivotIndex+1, end);
	}

	//分治函数，返回基准元素位置
	public int partition(int[] arr, int start, int end){
		int pivot = arr[start];
		int mark = start;    //指针，小于基准元素的区域边界

		for(int i = start+1; i<=end; i++){
			if(arr[i] < pivot){        //交换[++mark]和[i]位置的元素，将小的元素移到mark边界左边。
				mark++;
				int tmp = arr[mark];
				arr[mark] = arr[i];
				arr[i] = tmp;
			}
		}

		arr[start] = arr[mark];    //此时pivot还在头部，与[mark]元素交换，放到基准位置。
		arr[mark] = pivot;

		return mark;
	}
}
