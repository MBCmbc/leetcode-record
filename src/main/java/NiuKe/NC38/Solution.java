package NiuKe.NC38;

import java.util.*;
/*
螺旋矩阵，同leetcode P54。思路是有，但代码还是写的千疮百孔，拉跨，需要继续加强。
 */
public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
		int rows = matrix.length, columns = matrix[0].length;
		int up=0, down = rows-1, left=0, right = columns-1;
		while(up <= down && left <= right){
			for(int c=left; c<=right; c++) res.add(matrix[up][c]);
			for(int r=up+1; r<=down; r++) res.add(matrix[r][right]);
			if(up < down){//余下矩阵有两行及以上的情况下，才有必要向左遍历
				for(int c=right-1; c>=left; c--) res.add(matrix[down][c]);
			}
			if(left < right){//余下矩阵有两列及以上的情况下，才有必要向上遍历。
				for(int r=down-1; r>=up+1; r--) res.add(matrix[r][left]);
			}

			++up;
			--down;
			++left;
			--right;
		}

		return res;
	}
}
