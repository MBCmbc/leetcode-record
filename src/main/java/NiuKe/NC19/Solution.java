package NiuKe.NC19;

/*
子数组的最大累加和问题，动态规划求解。
同剑指offer P42
 */
public class Solution {
	/**
	 * max sum of the subarray
	 * @param arr int整型一维数组 the array
	 * @return int整型
	 */
	public int maxsumofSubarray (int[] arr) {
		// write code here
		int prev = arr[0], res = arr[0];
		int curr;
		for(int i = 1; i < arr.length; i++){
			if(prev > 0){
				curr = prev + arr[i];
			} else {
				curr = arr[i];
			}
			res = Math.max(res, curr);
			prev = curr;
		}

		return res;
	}
}
