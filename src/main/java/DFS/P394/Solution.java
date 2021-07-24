package DFS.P394;

/*
官方题解，方法二，递归

时间复杂度：O(S)，S为解码后得到字符串长度           打败88.97%
空间复杂度：O(|s|)，s为原字符串长度                 打败56.69%
*/

class Solution {
	String src;
	//字符串下标指针，表明当前位置
	int ptr;

	public String decodeString(String s) {
		src = s;
		int ptr = 0;
		return getString();
	}

	//递归函数
	public String getString(){
		//递归边界条件
		if(ptr == src.length() || src.charAt(ptr) == ']') return "";

		char curr = src.charAt(ptr);
		//字符串片段重复次数
		int repTime = 1;
		//result
		String ret = "";

		if(Character.isDigit(curr)){
			repTime = getDigits();
			//过滤左括号
			ptr++;
			//解析获取子字符串
			String str = getString();
			//过滤右括号
			ptr++;
			//构造字符串
			while(repTime-- > 0){
				ret += str;
			}
		} else if(Character.isLetter(curr)){
			ret = String.valueOf(curr);
			ptr++;
		}

		return ret + getString();
	}

	//获取重复次数的函数
	public int getDigits(){
		int ret = 0;
		while(ptr < src.length() && Character.isDigit(src.charAt(ptr))){
			ret = ret * 10 + src.charAt(ptr++) -'0';
		}
		return ret;
	}
}
