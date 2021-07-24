package JzOffer.P12;

/*
剑指offer回溯思想，具体实现方法为DFS加剪枝。
https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/

时间复杂度：O(3^K*M*N)，遍历长度为K的字符串，每次有三个方向要走，故为O(3^K)，又因为有M*N个起点，故总的时间复杂度为O(3^K*M*N)        打败97.78%
空间复杂度：O(K),最坏情况下K=MN                                                                                             打败71.13%
*/

class Solution {
	private char[][] board;
	private char[] words;

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.words = word.toCharArray();

		//以矩阵每个元素为起点进行寻路
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(dfs(i, j, 0)) return true;
			}
		}

		//所有元素为起点都无法找到要求路径，返回false
		return false;
	}

	//i，j为元素在矩阵内坐标，k为words中的元素下标，表示当前寻路到words中第几个元素
	public boolean dfs(int i, int j, int k){
		//board[i][j]没有越界，并且与words[k]相等，才有继续寻路的必要，否则剪枝。
		if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j] != words[k]) return false;
		//board[i][j]==words[k]且已经寻路到最后一个元素，寻路成功。
		if(k == words.length-1) return true;
		//标记矩阵当前元素被访问过
		board[i][j] = ' ';
		boolean res = dfs(i-1, j, k+1) || dfs(i+1, j, k+1) || dfs(i, j-1, k+1) || dfs(i, j+1, k+1);
		//所有子树寻路完毕，恢复矩阵元素值，因为已知board[i][j]==words[k]，故恢复为word[k]即可。
		board[i][j] = words[k];
		return res;
	}
}
