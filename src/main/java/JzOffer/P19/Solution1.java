package JzOffer.P19;

/*
剑指offer是递归思想，这里用了大佬的dp思想。
https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/

时间复杂度：O(NM)，N和M分别是字符串s和正则表达式p的长度。           打败99.34%
空间复杂度：O(NM)                                               打败84.62%
*/

class Solution1 {
	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();
		boolean[][] f = new boolean[n+1][m+1];
		for(int i=0; i<=n; i++){
			for(int j=0; j<=m; j++){
				if(j==0){//空正则串
					f[i][j] = (i==j);
				}else{//非空正则串
					if(p.charAt(j-1) != '*'){//正则串当前字符非'*'
						if(i>0 && (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))){
							f[i][j] = f[i-1][j-1];
						}
					} else{//碰到'*'了
						//不看'*'
						if(j >= 2){
							f[i][j] |= f[i][j-2];
						}
						//看'*'
						if(i>=1 && j>=2 && (p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2))){
							f[i][j] |= f[i-1][j];//看或不看两种情况任由一种为true即可，所以是“或等”。
						}
					}
				}
			}
		}

		return f[n][m];
	}
}
