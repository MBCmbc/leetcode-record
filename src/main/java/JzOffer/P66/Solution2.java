package JzOffer.P66;

/*
大佬解法。
https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
思路与剑指offer是相同的，不过这里利用巧妙的方式将空间复杂度降到了O(1)。
具体思路可以看一下大佬的题解以及动画，很清楚，但是有一点绕，直接用剑指offer思路写更清晰一点。

大致方法是先计算左半部分A[0]×A[1]×…×A[i-1]，并且左半部分的结果直接存储到结果数组b[i]中，这样可以利用递推公式b[i]=b[i-1]*a[i-1]从前往后递推。
然后返回来计算后半部分A[i+1]×…×A[n-1]，用辅助变量tmp记录右半部分，然后乘到b[i]上，即可得到最终结果。

时间复杂度：O(N)，两个for循环。                             打败78.6%
空间复杂度：O(1)，数组b[]是结果，不算，其他只用O(1)空间。       打败90.1%（只有一次达到了，其他大部分时候和空间复杂度O(N)的Solution1差不多，甚至更差一些。应该是因为leetcode计算空间占用的时候是不会把结果数组b[]去掉的,所以也接近于O(N)的。）
*/

class Solution2 {
	public int[] constructArr(int[] a) {
		if(a==null || a.length == 0) return new int[0];     //特殊情况
		int len = a.length;
		int[] b = new int[len];
		b[0] = 1;           //初始化b[0]
		int tmp = 1;        //计算右半部分时的辅助变量，初始化为1
		for(int i = 1; i < len; i++) b[i] = b[i-1] * a[i-1];        //递推计算左半部分，当前循环结束b[i]就代表左半部分的乘积。
		for(int i = len - 2; i >= 0; i--) {                         //递推计算右半部分
			tmp *= a[i+1];                                          //tmp即右半部分的值
			b[i] *= tmp;                                            //将tmp乘到b[i]上即将左右两个部分乘完毕，得到结果。
		}

		return b;
	}
}
