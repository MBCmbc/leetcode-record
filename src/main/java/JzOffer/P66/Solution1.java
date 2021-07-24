package JzOffer.P66;

/*
剑指offer思路，自己代码实现。
把b[i] = a[0]×a[1]×…×a[i-1]×a[i+1]×…×a[n-1]拆分为两个部分c[i]*d[i]，即c[i] = a[0]×a[1]×…×a[i-1]，d[i] = d[i+1]×…×d[n-1]。
辅助数组c[i]和d[i]可以递推得到，即c[i] = c[i-1] * a[i-1]，以及d[i] = d[i+1] * a[i+1]。
构造得到两个辅助数组后，对应项相乘c[i]*d[i]即可得到b[i]。

时间复杂度：O(N)，N为数组长度，三个for循环需要O(N)。            打败78.6%
空间复杂度：O(N)，存储辅助数组c[i]和d[i]所需要的空间。          打败82.87%
*/

class Solution1 {
	public int[] constructArr(int[] a) {
		if(a==null || a.length==0) return new int[0];       //特殊情况
		int len = a.length;
		int[] b = new int[len];     //结果数组
		int[] c = new int[len];     //两个辅助数组
		int[] d = new int[len];

		//构造两个辅助数组
		c[0] = 1;
		for(int i = 1; i < len; i++) c[i] = c[i-1] * a[i-1];
		d[len-1] = 1;
		for(int i = len-2; i >= 0; i--) d[i] = d[i+1] * a[i+1];

		//计算得到结果数组
		for(int i = 0; i < len; i++) b[i] = c[i] * d[i];

		return b;
	}
}
