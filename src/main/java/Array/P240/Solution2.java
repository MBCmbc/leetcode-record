package Array.P240;

/*
官方题解，方法四。
https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
思路：根据矩阵的特点进行剪枝，由于行向右升序，列向下升序，所以先把初始指针置于左下角。若currVal < target，就向右一列，若currVal > target，就向上一行。直至找到target，或走出矩阵边界。

时间复杂度：O(M+N)，M和N是矩阵的行数和列数。左下角出发每次向右或向上，最多走M+N步。             打败89.86%
空间复杂度：O(1)。                                                                        打败35.1%
*/

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, columns = matrix[0].length;
        int r = rows - 1, c = 0;    //初始指针置于左下角

        while(r >= 0 && c <= columns - 1){
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) c++;     //小于target，向右
            else if(matrix[r][c] > target) r--;     //大于target，向上
        }

        return false;   //没找到target。
    }
}
