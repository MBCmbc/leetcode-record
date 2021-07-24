package Array.P74;

/*
自己的解法，从左到右从上到下遍历查找。

时间复杂度：O(MN)，最坏情况下需要遍历整个矩阵                       打败100%
空间复杂度：O(1)                                                 打败26.04%
*/
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix== null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0 ; j < columns; j++){
                if(matrix[i][j] == target) return true;             //找到target，返回true
                else if (matrix[i][j] > target) return false;       //矩阵升序，如果当前元素都大于target了，肯定不存在target，返回false。
            }
        }

        return false;
    }
}
