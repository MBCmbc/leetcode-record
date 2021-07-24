package DynamicProgramming.P70;

/*
入门级动态规划题目，详细思路见官方题解。

思路：
    1. 由于每次只能走1步或2步，用F(x)表示走到第x个台阶的不同方法个数，可以得到状态转移方程：F(x)=F(x-2)+F(x-1)。
    2. 对于x=1和x=2，很显然可以得到问题的边界条件F(1)=1，F(2)=2。
    3. 用result代表F(x)，a代表F(x-2)，b代表F(x-1)，根据状态转移方程可以得到for循环内关于值更新的代码。

时间复杂度：O(N)    打败100%
空间复杂度：O(1)    打败41.06%
*/

class Solution {
	public int climbStairs(int n) {
		//边界条件可直接返回
		if(n==1) return 1;
		if(n==2) return 2;

		//边界条件初始化，result代表F(x)，a代表F(x-2)，b代表F(x-1)。
		//此处从x=3开始求解，故用F(1)初始化a，F(2)初始化b
		int result=0, a=1, b=2;
		for(int i=3; i<=n; i++){
			//状态转移方程
			result = a+b;
			//本次循环中的F(x-1)即为下次循环中的F(x-2)
			a=b;
			//本次循环中的F(x)即为下次循环中的F(x-1)
			b=result;
		}

		return result;
	}
}
