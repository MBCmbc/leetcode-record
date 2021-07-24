package JzOffer.P60;

/*
参考大佬题解，实现代码。动态规划思想。
https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-dong-tai-gui-hua-by-zhi-xiong/
把n个骰子的情况，看作是由n-1个骰子和1个骰子组合而得来。用pre数组代表n-1个骰子，tmp数组代表n个骰子，one代表一个骰子
则可以得到递推公式：tmp[x+y] += pre[x]*one[y]。（经过从左到右的遍历，所有和为x+y的组合，都会被放到x+y这个位置上）

时间复杂度：打败100%
空间复杂度：打败43.14%
*/

class Solution {
	public double[] dicesProbability(int n) {
		double[] pre = new double[]{1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};    //最初的pre，也即1个骰子的情况
		for(int i = 2; i <= n; i++){    //循环推算i个骰子的情况，直到最终n个骰子的情况
			double[] tmp = new double[i * 5 + 1];   //tmp代表本轮要计算的数组，即i个骰子的情况。i为骰子个数，长度为6*i-1*i+1 = 5*i+1
			for(int j = 0; j < pre.length; j++){    //循环计算i-1个骰子（j为下标）情况下，再加一个骰子（x为下标），形成的i个骰子的数组。
				for(int x = 0; x < 6; x++) {
					tmp[j+x] += pre[j]/6;           //根据状态转移公式得出。    1个骰子情况下概率均为1/6，所以直接除以6即可。
				}
			}
			pre = tmp;
		}

		return pre;
	}
}
