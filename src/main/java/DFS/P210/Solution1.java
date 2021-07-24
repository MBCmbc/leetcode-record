package DFS.P210;

/*
官方题解，方法一，dfs。
思路：即“拓扑排序”问题，关键在于：1.判断图中是否有环； 2. 用栈存储课程排序

时间复杂度：O(N+M)，其中N为课程数，M为关于先修课程要求的数量。          打败99.71%
空间复杂度：O(N+M)                                                     打败99.32%
*/

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	//存储有向图的邻接表
	List <List<Integer>> edges;
	//标记每个节点的状态，0表示未搜索，1表示正在搜索，2表示搜索已完成
	int[] visited;
	//用于存储结果的“栈”，0为栈顶，n-1为栈底
	int[] result;
	//判断图中是否有环
	boolean valid = true;
	//栈的下标
	int index;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; ++i){
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourses];
		result = new int[numCourses];
		index = numCourses-1;
		for(int[] info : prerequisites){
			edges.get(info[1]).add(info[0]);
		}

		//对每个“未搜索”节点进行dfs
		for(int i=0; i<numCourses && valid; ++i){
			if(visited[i] == 0) dfs(i);
		}

		if(!valid) return new int[0];

		//无环，则返回拓扑排序
		return result;
	}

	public void dfs(int u){
		//将节点标记为搜索中
		visited[u] = 1;
		//遍历搜索相邻节点，发现环后立即停止搜索
		for(int v : edges.get(u)){
			//如果是“搜索中”，说明有环
			if(visited[v] == 1){
				valid = false;
				return;
			} else if(visited[v] == 0){
				//如果是“未搜索”，则继续dfs搜索
				dfs(v);
				if(!valid) return;
			}
		}

		//搜索完毕，标记为“已完成”
		visited[u] = 2;
		//节点入栈
		result[index--] = u;
	}
}
