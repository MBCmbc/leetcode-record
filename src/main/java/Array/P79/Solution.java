package Array.P79;

/*
https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
思路：回溯。（我也想用回溯来着，但是代码写不出来。。。。lj）
执行用时：打败77.97%
内存消耗：打败79.13%
*/

class Solution {
	//m和n分别为二维网格的行数和列数
	private int m;
	private int n;
	private String word;
	private char[][] board;
	//标记二维网格上的各个点是否已经被用过
	private boolean[][] marked;
	//四个可能的前进方向
	private int[][] direction = {{0,1}, {1,0}, {-1,0}, {0, -1}};

	public boolean exist(char[][] board, String word) {
		this.word = word;
		this.board = board;
		this.m = board.length;
		if(m == 0) return false;
		n = board[0].length;
		marked = new boolean[m][n];

		//dfs搜索， 以每个点为起始都进行搜索，找得到就返回true，都找不到就返回false。
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(dfs(i, j, 0)){
					return true;
				}
			}
		}

		return false;
	}

	public boolean dfs(int i, int j, int start){
		//如果已经是word的最后一位了，只比较一下当前即返回，不能在往下比了，后面没有了，取不出字符来了。否则会导致word的指针越界异常。
		if(start == word.length()-1) return board[i][j] == word.charAt(start);
		//如果当前点符合word当前位的要求，marke为true，表示访问过，并对四个方向进行进一步的搜索。
		if(board[i][j] == word.charAt(start)){
			marked[i][j] = true;
			for(int k=0; k<4; k++){
				//按方向更新下一个要搜索的点
				int newX = i + direction[k][0];
				int newY = j + direction[k][1];
				//如果新点在网格内而且没被使用过，才能继续搜索。
				if(inArea(newX, newY) && !marked[newX][newY]){
					if(dfs(newX, newY, start+1)){
						return true;
					}
				}
			}
			//如果四个方向的新点都不符合要求，那么当前点符合不符合也就没有意义，故放弃本点，并取消标记，以便其他轮次的搜索访问该点。
			marked[i][j] = false;
		}
		//如果走到这一步都没有返回true，说明要么当前点不符合，要么当前点的后续四个新点不符合，总之就是不符合，返回false。
		return false;
	}

	//判断要搜索的点是否在网格区域内。
	public boolean inArea(int x, int y){
		return x>=0 && x<m && y>=0 && y<n;
	}
}