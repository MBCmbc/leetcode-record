package JzOffer.P13;

/*
自己的解法，和官方题解大同小异，只是把不满足数位之和<=k的也标记起来，就不用重复计算了。
时间复杂度和空间复杂度并没有优化，但由于记忆化搜索，减少了计算数位之和的次数，所以耗时减少了。

时间复杂度：打败83.98%
空间复杂度：打败57.54%
*/

class Solution2 {
    private int cnt = 0;
    private int m;
    private int n;
    private int k;
    private int[][] flag;   //值为1表示访问过，值为2表示不符合数位之和<=k的要求。

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.flag = new int[m][n];

        recur(0, 0);
        return cnt;
    }

    private void recur(int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || !check(r, c)) return;

        if(flag[r][c] == 0){
            cnt++;
            flag[r][c] = 1;
        }

        //recur(r-1, c);
        recur(r+1, c);
        //recur(r, c-1);
        recur(r, c+1);
    }



    private boolean check(int r, int c){
        if(flag[r][c] != 0) return false;

        int sum = 0;
        while(r > 0){
            sum += r % 10;
            r /= 10;
        }

        while(c > 0){
            sum += c % 10;
            c /= 10;
        }

        if(sum > k){
            flag[r][c] = 2;
            return false;
        }

        return true;
    }
}
