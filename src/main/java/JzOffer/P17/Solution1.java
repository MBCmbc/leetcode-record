package JzOffer.P17;

/*
不考虑大数的情况。根据n算出最大值max，然后把小于max的整数都存到数组里就可以了。

时间复杂度：O(10^N)             打败100%
空间复杂度：O(1)                打败57.29%
*/

class Solution1 {
	public int[] printNumbers(int n) {
		int max = 1;
		int i = 0;
		while(i < n){
			max *= 10;
			i++;
		}

		int[] res = new int[max-1];
		for(int j=0; j<max-1; j++){
			res[j] = j+1;
		}

		return res;
	}
}
