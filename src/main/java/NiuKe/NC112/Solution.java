package NiuKe.NC112;

/*
整数M转换为N进制数（2<=N<=16）,采用除N取余，倒序排列的算法。
*/
public class Solution {
	/**
	 * 进制转换
	 * @param M int整型 给定整数
	 * @param N int整型 转换到的进制
	 * @return string字符串
	 */
	public String solve (int M, int N) {
		// write code here
		if(M == 0) return "0";
		String s = "0123456789ABCDEF";            //巧妙，最多十六进制，把要用的字符都放在s里，后面再取就可以了。
		StringBuilder sb = new StringBuilder();
		boolean f = false;                        //标记是否为负数

		if(M < 0){
			f = true;
			M = -M;
		}

		while(M > 0){                        //除N取余
			sb.append(s.charAt(M % N));
			M /= N;
		}

		if(f) sb.append("-");
		return sb.reverse().toString();        //倒序排列
	}
}
