package Array.P289;

/*
官方题解，方法二。
思路：通过巧妙地设计复合状态，实现原地算法。

复合状态码设置如下：
活——>死    -1
死——>死     0
活——>活     1
死——>活     2
可以看到，原本状态为“活”的细胞对应的复合状态码绝对值都为1；新状态为“活”的细胞对应的复合状态码都大于0。

时间复杂度：两次遍历网格，故为O(M*N),M和N分别表示网格的长和宽。             执行用时：打败100%
空间复杂度：额外只用了常数空间用于存放变量，故为O(1)。                      内存消耗：打败78.74%
*/

class Solution {
	public void gameOfLife(int[][] board) {
		//网格的行数和列数
		int rows = board.length;
		int cols = board[0].length;
		//按行按列第一次遍历网格，进行状态标记。
		for(int row=0; row<rows; row++){
			for(int col=0; col<cols; col++){
				//统计每个格子周围八个格子中活细胞的数目。
				int liveCount = 0;
				for(int i=-1; i<=1; i++){
					for(int j=-1; j<=1; j++){
						//排除格子自身，只计算周围八个格子
						if(!(i==0 && j==0)){
							//计算周围点的坐标
							int r = row+i;
							int c = col+j;
							//由于巧妙的状态设置，就算周围元素被更改过，只要绝对值为1，就说明细胞原来状态是活的。
							if(r>=0 && r<rows && c>=0 && c<cols && Math.abs(board[r][c])==1){
								liveCount++;
							}
						}
					}
				}

				//根据规则给网格赋值(复合状态码)
				//只需要考虑“活——>死”和“死——>活”两种情况即可，另外两种情况复合状态码和原状态码是一样的。
				if(board[row][col]==1 && (liveCount<2 || liveCount>3)) board[row][col] = -1;
				if(board[row][col]==0 && liveCount==3) board[row][col] = 2;
			}
		}

		//第二次遍历网格，根据复合状态码为细胞赋正常的0或1
		for(int row=0; row<rows; row++){
			for(int col=0; col<cols; col++){
				//根据复合状态码的特征，复合状态码大于0则细胞的新状态为“活”，否则为“死”。
				if(board[row][col] > 0){
					board[row][col] = 1;
				}else{
					board[row][col] = 0;
				}
			}
		}
	}
}