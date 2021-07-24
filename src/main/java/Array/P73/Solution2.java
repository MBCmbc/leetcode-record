package Array.P73;

/*
官方题解，方法一。和自己的方法思路一致，但其根据HashSet置0的方式不太一样。
思路：用两个HashSet分别存储有0出现的行数和列数，遍历矩阵找出有0出现的行数和列数存入HashSet，再根据HashSet的记录，依次将这些行和列置0.
时间复杂度：O(mn)           执行用时：打败24.08%
空间复杂度：O(m+n)          内存消耗：打败42.33%
*/

import java.util.HashSet;

class Solution2 {
	public void setZeroes(int[][] matrix) {
		int m=matrix.length, n=matrix[0].length;
		//用于存储有0出现的行下标和列下标
		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> columns = new HashSet<>();
		//第一次遍历，记录有0出现的行下标和列下标
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					rows.add(i);
					columns.add(j);
				}
			}
		}

		//第二次遍历，根据HashSet记录，如果某个元素处于需要置0的位置，则将其置0
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//行下标出现在rows里，或列下标出现在columns里，都表示该元素需要置0
				if(rows.contains(i) || columns.contains(j)){
					matrix[i][j] = 0;
				}
			}
		}
	}
}
