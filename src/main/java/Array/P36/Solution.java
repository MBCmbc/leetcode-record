package Array.P36;

import java.util.Arrays;

/*
自己实现，思路很简单，就是按照题目给的规定，进行三次判断即可。

时间复杂度：O(1)，board大小是固定的9*9，所以时间复杂度是O(1)。          打败95.36%
空间复杂度：O(1)，cnt数组长度为固定9，空间复杂度也为O(1)。              打败99.48%
*/
class Solution {
    private char[][] board;
    private int[] cnt = new int[9]; //由于只有1-9的数字出现，所以用一个长度为9的数组统计各个数字出现的次数。
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return checkRows() && checkColumns() && checkBoxes();   //三个条件都满足才返回true
    }

    //判断所有的行是否满足规则
    private boolean checkRows(){
        for(int i = 0; i < 9; i++){
            Arrays.fill(cnt, 0);    //每次都要重置cnt数组为0
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;    //空格忽略
                int idx = board[i][j] - '1';
                if(++cnt[idx] > 1) return false;
            }
        }

        return true;
    }

    //判断所有的列是否满足规则
    private boolean checkColumns(){
        for(int j = 0; j < 9; j++){
            Arrays.fill(cnt, 0);    //每次都要重置cnt数组为0
            for(int i = 0; i < 9; i++){
                if(board[i][j] == '.') continue;    //空格忽略
                int idx = board[i][j] - '1';
                if(++cnt[idx] > 1) return false;
            }
        }

        return true;
    }

    //判断所有的3*3块是否满足规则
    private boolean checkBoxes(){
        for(int i = 0; i < 9; i=i+3){
            for(int j = 0; j < 9; j = j + 3){
                if(!checkBox(i, j)) return false;
            }
        }

        return true;
    }

    //判断一个3*3块是否满足规则
    private boolean checkBox(int x, int y){
        Arrays.fill(cnt, 0);    //每次都要重置cnt数组为0
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[x+i][y+j] == '.') continue;    //空格忽略
                int idx = board[x+i][y+j] - '1';
                if(++cnt[idx] > 1) return false;
            }
        }
        return true;
    }
}
