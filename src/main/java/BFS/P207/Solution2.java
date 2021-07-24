package BFS.P207;

/*
DFS包中P207的BFS解法
 */

/*
与P210同样的问题，返回值不同而已，题解也是几乎相同的。

官方题解，方法二，bfs
思路：用一个队列存储所有入度为0的节点，即可以加入到结果序列中的节点，并且在将其从图中取出之后，其所有相邻接点的入度减1，不断bfs，直到把所有点加入到结果序列中。

时间复杂度：O(N+M),其中N为课程数，M为先修课程的要求数           打败71.48%
空间复杂度：O(N+M)                                              打败74.46%
*/

import java.util.*;

class Solution2 {
	//存储有向图的邻接表
	List<List<Integer>> edges;
	//存储各个节点的入度
	int[] indeg;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//各数据结构初始化
		edges = new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; ++i){
			edges.add(new ArrayList<Integer>());
		}
		indeg = new int[numCourses];
		//填充图的邻接表
		for(int[] info : prerequisites){
			edges.get(info[1]).add(info[0]);
			indeg[info[0]] += 1;
		}

		//bfs中用到的队列,将所有入度为0的节点加入该队列
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++){
			if(indeg[i] == 0) queue.offer(i);
		}

		//存储已经访问过，或者说加到结果队列中的节点数
		int visited = 0;
		//bfs
		while(!queue.isEmpty()){
			//从队列首部取出一个节点放入答案数组中
			int u = queue.poll();
			visited++;
			//u所有的相邻节点的入度减1，如果减为0，就加入队列
			for(int v : edges.get(u)){
				indeg[v] -= 1;
				if(indeg[v] == 0) queue.offer(v);
			}
		}

		//若结果数组长度与需要上课的数目不等，说明还有课没被加到结果数组中，而此刻队列已经空了，说明这些未添加的节点入度始终不为0，肯定是因为有环，故无法满足题目要求，返回空数组即可。
		return visited == numCourses;
	}
}