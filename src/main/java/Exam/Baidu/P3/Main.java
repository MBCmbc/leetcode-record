package Exam.Baidu.P3;

import java.util.*;
/*
2021.3.30百度笔试，第三题。
n个学生，m个食堂，第i个食堂有a_i个窗口可以排队。每个学生等概率选择一个食堂，一个食堂内学生排队时都倾向于使最长的队伍尽可能短，
请计算所有食堂内最长队伍长度的期望值。

输入：第一行两个正整数n和m，第二行m个整数a_i。
	1 <= m,n <= 50
	1 <= a_i <= 50
	1 <= n <=500
	1 <= a[i] <= n


示例1：
	输入：
		5 5
		5 5 5 5 5
	输出：
		1.0000000000
示例2：
	输入：
		2 4
		1 1 1 1
	输出：
		1.2500000000
示例3：
	输入：
		2 2
		1 1
	输出：
		1.5000000000
 */
/*
思路：用dp[i][j][k]表示共i个房间剩下j个人最长队伍是k的概率，转移的时候就枚举当前房间的人数，
	  概率乘上所有剩下的人中选择这么多人并且他们都进这个房间的概率.期望就是sum(dp[m][0][i]*i)   (i=1~n)
https://blog.csdn.net/morejarphone/article/details/52825591
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] a = new int[60];	//每个食堂的窗口数
		for (int i = 1; i <= m; i++) a[i] = in.nextInt();

		double[][] C = new double[60][60];
		for(int i = 0; i < 60; i++) C[i][0] = 1;
		for (int i = 1; i <= 50; i++) {
			for (int j = 1; j <= i; j++) {
				C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
			}
		}

		double[][][] dp = new double[60][60][60];
		dp[0][0][0] = 1.0d;

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= j; k++) {
					for (int l = 0; l <= n - j; l++) {
						dp[i][j + l][Math.max(k, (l + a[i] - 1) / a[i])] += dp[i - 1][j][k] * C[n - j][l];
					}
				}
			}
		}

		double tmp1 = 0.0d, tmp2 = 0.0d;
		for (int i = 0; i <= n; i++) {
			tmp1 += dp[m][n][i];
			tmp2 += dp[m][n][i] * i;
		}

		System.out.println(tmp2 / tmp1);
	}
}
