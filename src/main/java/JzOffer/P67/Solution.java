package JzOffer.P67;

/*
同leetcode P08
自己根据题目要求一步一步实现的，其实就是分析题意，然后排除各种意外情况后进行解析，只是过程比较繁杂，需要耐心解决编码过程中出现的各种小bug。

时间复杂度：O(N)，N为str长度，需要遍历str。             打败99.55%
空间复杂度：O(N)，用数组chars存储了str。                打败86.26%
*/
class Solution {
	public int strToInt(String str) {
		if(str == null) return 0;       //空指针直接返回
		str = str.trim();               //去除两端空格
		char[] chars = str.toCharArray();   //转为字符数组好操作
		long result = 0;                    //用long型变量存储结果，方便应对溢出。
		boolean negative = false;           //标记是否为负数
		//若只包含空白字符 || 第一个非空格字符不在‘0~9’、'+'、'-'范围内，不符合要求，直接返回0。
		if(chars.length==0 || !((chars[0] >= '0' && chars[0] <= '9') || chars[0] == '+' || chars[0] == '-')) return 0;

		int index = 0;              //index指针标记当前遍历到chars的哪个位置了
		if(chars[0] == '-'){
			negative = true;        //若开头为'-'，标记为负数。
			index++;                //指针右移
		} else if(chars[0] == '+'){
			index++;                //开头为'+'，index指针直接右移。
		}

		while(index < chars.length){    //遍历chars数组
			//若遍历到非数字的字符 || 当前整数值已超过Integer.MAX_VALUE就可以停止遍历了（因为哪怕long型也会溢出的，所以需要提前终止）
			if(!(chars[index]>='0' && chars[index]<='9') || result > Integer.MAX_VALUE) break;
			result = result*10 + chars[index++] - '0';      //result中加入当前位。
		}

		if(negative){               //加上正负号
			result = -result;
			result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;       //根据要求，溢出则返回int型的边界值。
		} else{
			result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
		}

		return (int)result;     //转为int后返回。
	}
}