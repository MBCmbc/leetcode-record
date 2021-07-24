package DFS.P200;

/*
官方题解，方法一：深度优先搜索

思路：根据题意，只有上下相连或者左右相连才能认为是同一个岛屿，所以我们只需要往上下左右四个方向进行搜索。
      遍历grid，一旦遇到1就开始进行dfs搜索，不断地深度搜索与此“1”相连的所有“1”，以及与第2层“1”相连的所有“1”，与第三层“1”相连的所有1，预见0则停止搜索。
      并且，对于所有遍历过的“1”，将其置“0”，以免下次遍历到该“1”的时候重复搜索。

      最终，我们进行“根”dfs的次数，也就是岛屿的个数，返回即可。

时间复杂度：O(MN)，M和N分别是grid的行数和列数，双重循环导致时间复杂度为O(MN)。                              打败97.66%
空间复杂度：O(MN)，最坏情况下，grid全为“1”，单次dfs需要的栈空间达到MN，故空间复杂度为O(MN)。                打败98.44%
*/

class Solution {
	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0){
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int result = 0;

		//遍历grid
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j] == '1'){
					//当前值为1，又网格四边均被水保卫，所以不论大小肯定是1个岛屿了，直接result+1即可。
					result++;
					dfs(grid, i, j);
				}
			}
		}

		return result;
	}

	//dfs函数
	public void dfs(char[][] grid, int r, int c){
		int m = grid.length;
		int n = grid[0].length;
		//各种边界条件
		if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0'){
			return;
		}

		//当前‘1’计算过了，置‘0’以免重复搜索
		grid[r][c] = '0';
		//进行下一层的dfs
		dfs(grid, r+1, c);
		dfs(grid, r-1, c);
		dfs(grid, r, c-1);
		dfs(grid, r, c+1);
	}
}
