package DFS.P130;

/*
官方题解，方法一，DFS
思路：根据题意，所有与边界上的'O'直接或间接相连的‘O’都没有被‘X’包围，而剩下的所有‘O’都有被围绕，需要置为‘X’
      以边界上的'O'为起点，开始进行dfs，若有'O‘与其相连，则标记为‘A’。

      dfs全部结束后，遍历矩阵，标记了'A'的，还原为'O'，而没有被标记的'O'，则置为'X'。

记M和N分别为board的长度和高度，则：
时间复杂度：O(MN),深度优先搜索过程中，每一个点至多只会被标记一次。          打败96.91%
空间复杂度：O(MN)，深度优先搜索的栈的开销。                                 打败97.24%
*/

class Solution {
	//全部变量，表示board的行数和列数
	int rows;
	int columns;

	public void solve(char[][] board) {
		rows = board.length;
		//board为空则直接返回
		if(rows == 0) return;
		columns = board[0].length;

		//以边界上的‘O’为七点，进行dfs。
		//这里虽然没有判断，但是在dfs函数里一进去就判断了的。
		for(int i=0; i<rows; i++){
			dfs(board, i, 0);
			dfs(board, i, columns-1);
		}
		for(int i=0; i<columns; i++){
			dfs(board, 0, i);
			dfs(board, rows-1, i);
		}

		//根据标记进行赋值
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				if(board[i][j] == 'A'){
					board[i][j] = 'O';
				} else if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfs(char[][] board, int r, int c){
		//1.已经超过边界必然结束搜索
		//2.若当前元素不为‘O’，则要么是‘X’，要么已经搜索过，标记为‘A’了，不需要再搜索
		//3.对于第一层dfs，也起到作用，只对边界上的‘O’为起点进行搜索，边界上不是‘O’的元素不展开搜索
		if(r<0 || c<0 || r>= rows || c>=columns || board[r][c]!='O') return;

		//与边界上的‘O’直接或间接相连，标记为‘A’
		board[r][c] = 'A';
		//对当前元素的上下左右四个方向进行搜索
		dfs(board, r-1, c);
		dfs(board, r+1, c);
		dfs(board, r, c+1);
		dfs(board, r, c-1);
	}
}
