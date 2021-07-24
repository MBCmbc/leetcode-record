package Array.P118;

import java.util.ArrayList;
import java.util.List;

/*
自己的解法：按照杨辉三角的生成规则，一层一层的去生成就可以了。（其实是动态规划）
注意：第一层和第二层作为初始条件，需要手动地初始化，或者说生成。
从第三行开始，行两端为1，行中间的数据则利用上一行的数据生成。
时间复杂度：两重for循环，O(N^2)。                                                           执行用时：打败100%
空间复杂度：因为我们需要存储我们在 triangle 中更新的每个数字，所以空间需求与时间复杂度相同。      内存消耗：打败9.09%
*/

class Solution1 {
	public List<List<Integer>> generate(int numRows) {
		//结果集合
		List<List<Integer>> result = new ArrayList<>();

		//numRows为0，直接返回空的集合。
		if(numRows == 0) return result;

		//numRows不为0，起码有一行，先把这一行加进去再说。
		List<Integer> subList1 = new ArrayList<Integer>();
		subList1.add(1);
		result.add(subList1);

		//numRows为1的话，直接把上面有一行数据的集合返回即可。
		if(numRows == 1) return result;

		//到这里可以确定numRows>1，无论如何都要添加第二行的，所以生成并添加。
		List<Integer> subList2 = new ArrayList<Integer>();
		subList2.add(1);
		subList2.add(1);
		result.add(subList2);

		//numRows等于2，把上面有两行数据的集合返回即可。
		if(numRows == 2) return result;

		//到这里可以确定numRows>2，从第三行开始，利用动态规划的思想，从上一行数据生成下一行数据
		for(int i=3; i<=numRows; i++){
			//代表每一行的List集合。
			List<Integer> subList = new ArrayList<Integer>();
			//添加每行的第一个数据：1
			subList.add(1);
			//获取上一行数据
			List<Integer> lastList = result.get(i-2);
			//当前行内，利用for循环依次生成元素。
			for(int j=1; j<i-1; j++){
				//在当前行内，依次根据上一行对应数据计算得到本行相应位置的元素。
				int newElement = lastList.get(j-1) + lastList.get(j);
				subList.add(newElement);
			}
			//添加每一行的最后一个数据：1
			subList.add(1);

			//将当前行加入结果集。
			result.add(subList);
		}

		return result;
	}
}
