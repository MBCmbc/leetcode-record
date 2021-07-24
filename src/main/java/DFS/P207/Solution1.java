package DFS.P207;

/*
与P210同样的问题，返回值不同而已，题解也是几乎相同的。

官方题解，方法一，dfs。
思路：即“拓扑排序”问题，关键在于：1.判断图中是否有环； 2. 用栈存储课程排序

时间复杂度：O(N+M)，其中N为课程数，M为关于先修课程要求的数量。          打败99.46%
空间复杂度：O(N+M)                                                     打败99.92%
*/

import java.util.ArrayList;
import java.util.List;

class Solution1 {
	//存储有向图的邻接表
	List<List<Integer>> edges;
	//标记每个节点的状态，0表示“未搜索”，1表示“搜索中”，2表示“已搜索”
	int[] visited;
	//表示是否可能完成，也即结果。
	boolean valid = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//初始化各数据结构
		edges = new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; ++i){
			edges.add(new ArrayList<Integer>());
		}
		for(int[] info : prerequisites){
			edges.get(info[1]).add(info[0]);
		}
		visited = new int[numCourses];

		//对每个未搜索的节点进行dfs
		for(int i=0; i<numCourses && valid; ++i){
			if(visited[i] == 0) dfs(i);
		}

		return valid;
	}

	//dfs函数
	public void dfs(int u){
		//标记当前节点为“搜索中”
		visited[u] = 1;

		//遍历当前节点的邻接节点
		for(int v : edges.get(u)){
			//若为“搜索中”，说明有环，直接返回。
			if(visited[v] == 1){
				valid = false;
				return;
			} else if(visited[v] == 0){
				//如果是“未搜索”，则继续dfs搜索
				dfs(v);
				if (!valid) return;
			}
		}

		//所有邻接节点搜索完了，标记为“已完成”
		visited[u] = 2;
	}
}