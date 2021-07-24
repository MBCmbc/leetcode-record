package Array.P240;

/*
自己的解法，根据rows和columns的大小情况，rows更大，则对每列进行二分查找，否则对每行进行二分查找。

时间复杂度：min(O(MlogN), O(NlogM))，M和N代表矩阵的行数和列数               打败41.73%
空间复杂度：O(1)                                                         打败82.3%
*/

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        if(rows > columns) return columnBinary(matrix, rows, columns, target);  //行数多，对每列二分查找。
        else return rowBinary(matrix, rows, columns, target);   //否则对每行二分查找
    }

    //对每行进行二分查找
    private boolean rowBinary(int[][] matrix, int rows, int columns, int target){
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] > target) return false; //当前行的首个元素都大于target了，后面不可能有target，提前返回。
            if(matrix[i][0] <= target && matrix[i][columns-1] >= target){   //若target有可能在此行范围内，就二分查找。
                int lo = 0, hi = columns - 1;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if(matrix[i][mid] == target){
                        return true;
                    } else if(matrix[i][mid] < target){
                        lo = mid +1;
                    } else if(matrix[i][mid] > target){
                        hi = mid -1;
                    }
                }
            }
        }

        return false;       //没提前返回就是没找到，返回false。
    }

    //对每列进行二分查找
    private boolean columnBinary(int[][] matrix, int rows, int columns, int target){
        for(int i = 0; i < columns; i++){
            if(matrix[0][i] > target) return false;
            if(matrix[0][i] <= target && matrix[rows-1][i] >= target){
                int lo = 0, hi = rows - 1;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if(matrix[mid][i] == target){
                        return true;
                    } else if(matrix[mid][i] < target){
                        lo = mid +1;
                    } else if(matrix[mid][i] > target){
                        hi = mid - 1;
                    }
                }
            }
        }

        return false;
    }
}
