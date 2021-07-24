package NiuKe.NC68;

/*
青蛙跳台阶问题，最简单的动态规划，即斐波那契数列。F(n) = F(n-1) + F(n-2)
 */
public class Solution {
	public int JumpFloor(int target) {
		if(target <= 0) return 0;
		if(target == 1) return 1;
		if(target == 2) return 2;

		int res = 0, f1 = 1, f2 = 2;

		for(int i = 3; i <= target; i++){		//递推
			res = f1 + f2;
			f1 = f2;
			f2 = res;
		}

		return res;
	}
}
