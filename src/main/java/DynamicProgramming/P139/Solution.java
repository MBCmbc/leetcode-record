package DynamicProgramming.P139;

/*
官方题解+高亮回答：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-ju-jue-zhuang-xcong-jian-dan-de-xi/

思路：动态规划，用dp[i]表示s中前i个字符组成的字符串是否可以被正确拆分，构造转移方程：
        dp[i] = dp[j] && check(s.substring(j+1, i))
     其中check(s)表示s是否可以被正确拆分。具体实现方式可以看代码中的注释

时间复杂度：O(N*N)，两重循环                 打败87.57%
空间复杂度：O(N)，dp[]数组以及哈希表          打败82.34%

*/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		//用哈希表存放wordDict，以便后面以哈希的方式进行check
		Set<String> wordDictSet = new HashSet<>(wordDict);
		//动态规划数组，因为dp[i]表示前i个字符是否能被正确拆分，所以长度为len+1
		boolean[] dp = new boolean[s.length()+1];
		//初始化，dp[0]表示空字符串合法，从这一点也可以看出dp数组长度应为len+1
		dp[0] = true;

		//利用状态转移方程遍历更新dp数组
		for(int i=1; i<=s.length(); i++){
			//以从后往前的方式遍历，check()的实现方式就变成了检查wordDictSet中是否包含该单词
			for(int j=i-1; j>=0; j--){
				//因为boolean数组构造好后默认全为false，所以只要将需要改为true的地方改为true就好了，其他不用管。
				//这里注意dp[]数组的下标比字符串的下标大1，写边界的时候要仔细分析。
				if(dp[j] && wordDictSet.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}
}
