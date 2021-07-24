package Array.P73;

/*
自己的解法
思路：用两个HashSet分别存储有0出现的行数和列数，遍历矩阵找出有0出现的行数和列数存入HashSet，再根据HashSet的记录，依次将这些行和列置0.
时间复杂度：O(mn)           执行用时：打败42.87%
空间复杂度：O(m+n)          内存消耗：打败27.73%
*/

import java.util.HashSet;

class Solution1 {
	public void setZeroes(int[][] matrix) {
		int m=matrix.length, n=matrix[0].length;
		//用于存储有0出现的行下标和列下标
		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> columns = new HashSet<>();
		//遍历，记录有0出现的行下标和列下标
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					rows.add(i);
					columns.add(j);
				}
			}
		}

		//根据HashSet记录，将对应行置零0
		for(int row : rows){
			setZeroesRow(row, matrix);
		}

		//根据HashSet记录，将对应列置零0
		for(int column : columns){
			setZeroesColumn(column, matrix);
		}


	}

	//将行置0的辅助函数
	public void setZeroesRow(int row, int[][] matrix){
		for(int i=0; i<matrix[0].length; i++){
			matrix[row][i] = 0;
		}
	}

	//将列置0的辅助函数
	public void setZeroesColumn(int column, int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			matrix[i][column] = 0;
		}
	}
}
