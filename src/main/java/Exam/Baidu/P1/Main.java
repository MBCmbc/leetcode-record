package Exam.Baidu.P1;

import java.util.*;

/*
2021.3.30百度笔试第一题
牛牛很喜欢在数字序列中跳跃

现在他正站在1号位置,每次跳跃,他可以向后跳一步(即从跳到+1),也可以跳到该位置往后的任意一个与该位置上的数字相同的位置
例如：1，2，3，4，1 ，3，4，1 在第一个1的位置时，既可以跳一个，也可以跳到后面任意一个1的位置
请问他最少需要跳多少步才能跳到N号位?
输入描述:
第一行输入一个整数N，表示数字序列的长度
接下来一行为一个仅由数字0-9构成的数字串。
输出描述:
输出一个整数，表示最少步数

例子1；
	输入：
		5
		01212
	输出：
		3
	解析：
		最优方案为1 -> 2 -> 3 -> 5。需要三步。
例子2；
	输入：
		5
		21202
	输出：
		1
	解析：
		从第一个2直接跳到最后一个2即可。

 */
/*
思路：动态规划+哈希。
https://blog.csdn.net/qq_44745063/article/details/114988669
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();    //数字序列长度
		in.nextLine();
		String line = in.nextLine();
		char[] chars = line.toCharArray();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = chars[i] - '0';    //把输入数字序列构造成数组
		}

		int[] dp = new int[n];    //到达某个位置所需要的最少步数
		HashMap<Integer, Integer> map = new HashMap<>();    //到达数字key，所需要的最少步数value。
		dp[0] = 0;
		map.put(nums[0], 0);
		for (int i = 1; i < n; i++) {
			if (map.containsKey(nums[i])) { //该数字之前出现过，所以1.可以从前一个数走一步；2.也可以从到之前相同数字的最少步数处，直接一步跳到当前位置。
				dp[i] = Math.min(map.get(nums[i]) + 1, dp[i - 1] + 1);    //取二者中较小值即可。
				if(dp[i] < map.get(nums[i])) map.put(nums[i], dp[i]);	//如果到当前nums[i]步数更少，更新哈希表。//这是原答案没有的，我想应该也是为什么原答案只能过70%
			} else {
				dp[i] = dp[i - 1] + 1;    //没出现过，只能从前一个数字走一步到达当前位置。
				map.put(nums[i], dp[i]);	//更新哈希表
			}
		}

		System.out.println(dp[n - 1]);
	}
}
