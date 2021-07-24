package JzOffer.P20;

/*
按照剑指offer的思路，逐字符分析。
https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/javaban-ben-ti-jie-luo-ji-qing-xi-by-yangshyu6/

时间复杂度：O(N)，N为字符串长度                             打败100%
空间复杂度：O(N)，开辟了长度为N的char数组                   打败90.78%
*/

class Solution {
	public boolean isNumber(String s) {
		if(s == null || s.length() == 0) return false;
		//记录num、dot、e是否出现过的变量
		boolean numSeen = false;
		boolean dotSeen =false;
		boolean eSeen =false;
		char[] str = s.trim().toCharArray();
		for(int i=0; i<str.length; i++){
			if(str[i]>='0' && str[i]<='9'){
				numSeen = true;
			}else if(str[i] == '.'){
				if(dotSeen || eSeen) return false;  //dot出现之前不能出现dot或者e
				dotSeen = true;
			}else if(str[i]=='e' || str[i]=='E'){
				if(eSeen || !numSeen) return false;  //e出现之前不能出现e，必须有num
				eSeen = true;
				numSeen = false;   //重置numSeen，排除123e或者123e+的情况，确保e之后也有数
			}else if(str[i]=='+' || str[i]== '-'){
				if(i!=0 && str[i-1]!='e' && str[i-1]!='E') return false;   //'+'/'-'必须出现在str首位或者'e'/'E'之后。
			}else{//其他字符
				return false;
			}
		}

		//两种情况：
		//1. 没出现'e'/'E',则必须出现过num才行；
		//2. 出现了'e'/'E',同样后面也必须出现过num才行。
		//所以返回numSeen即可
		return numSeen;
	}
}
