package JzOffer.P13;

/*
剑指offer回溯，思路，dfs+剪枝实现代码。
由官方题解发现，每走完一格只需向右或向下，无需向上或向左，故而可以稍微优化一些。
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/

时间复杂度：O(MN)，最坏情况下考虑所有格子都能进入，搜索的时候一个格子最多被访问常数次（上边过来的和左边过来的），故O(2MN)=O(MN)。
            另，计算res的双重for循环也为O(MN)。             打败46.01%
空间复杂度：O(MN)，标记矩阵消耗的额外空间。                  打败86.81%
*/

class Solution {
	private int m,n,k;
	private int[][] visited;

	public int movingCount(int m, int n, int k) {
		this.m = m;
		this.n = n;
		this.k = k;
		//标记矩阵，1为可达且到过，0为不可达或没到过。
		this.visited = new int[m][n];

		int res = 0;
		dfs(0,0);
		//可以到达的位置被标记为了1，其他位置仍为0，故和即为可到达的格数
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				res += visited[i][j];
			}
		}

		return res;
	}

	public void dfs(int x, int y){
		int digitSum = getDigitSum(x, y);
		if(x<0 || x>m-1 || y<0 || y>n-1 || digitSum>k || visited[x][y]!=0) return;
		visited[x][y] = 1;
		//dfs(x-1, y);
		dfs(x+1, y);
		//dfs(x, y-1);
		dfs(x, y+1);
	}

	//计算某坐标数位之和的函数
	public int getDigitSum(int x, int y){
		int sum = 0;

		while(x>0){
			sum += x%10;
			x /= 10;
		}

		while(y>0){
			sum += y%10;
			y /= 10;
		}

		return sum;
	}
}
