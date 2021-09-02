package UnionFind.P399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author MBC
 * @Date 2021/8/28
 */
/*
官方题解，并查集
https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/

时间复杂度：O((N+Q)logA)，N为equations长度，Q为queries长度，A为equations里不同字符的个数。              打败100%
空间复杂度：O(A)。                                                                                   打败67.99%
*/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);

        //预处理，把变量映射为数字id，使得并查集的底层用数组实现，方便编码。
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);
        int id = 0;
        //将题目所给的等式关系，构造为并查集关系
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            //只有变量在之前的等式里没出现过，才为其分配一个id值。已经分配过id的变量，重复出现时不应再分配新id。
            if(!map.containsKey(var1)){
                map.put(var1, id++);
            }
            if(!map.containsKey(var2)){
                map.put(var2, id++);
            }

            //调用【合并】函数，构造初始并查集关系
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        //做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for(int i = 0; i < queriesSize; i++){
            //取出query的分子和分母
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            //映射为对应id值，方便利用并查集进行查询。
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if(id1 == null || id2 == null){
                //根据题意，query中任一变量没有出现过，都应该返回-1.0d
                res[i] = -1.0d;
            } else {
                //计算结果。
                res[i] = unionFind.isConnected(id1, id2);
            }
        }

        return res;
    }

    private class UnionFind {
        private int[] parent;   //各个节点的父节点
        private double[] weight;    //指向父节点的权值，这里即【子/父】结果

        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;          //各节点的父节点初始化为自己；即初始状态下，各节点自成一个集合
                weight[i] = 1.0d;       //父节点为自己，则对应权值【子/父 = 自己 / 自己】为1.0d
            }
        }

        //合并节点x和节点y所在的两个集合
        public void union(int x, int y, double value){
            int rootX = find(x);    //找到x所在集合的根节点
            int rootY = find(y);    //找到y所在集合的根节点
            if(rootX == rootY){     //已在同一集合，不必再【合并】，返回。
                return;
            }

            //不在同一集合，执行两个集合的【合并】
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];      //关系推导见题解
        }

        //找到x所在集合的根节点并返回；在寻找的过程中，同步进行路径压缩。
        //这两个操作一般是同步进行的，一边查询一边修改结点指向是并查集的特色。
        public int find(int x){
            if(x != parent[x]){     //还未找到根节点，递归查找，同时进行路径压缩。
                int origin = parent[x];        //当前父节点
                parent[x] = find(parent[x]);    //递归找到当前集合的根节点，作为新的父节点，压缩路径。
                weight[x] *= weight[origin];    //此时weight[origin]已经代表origin到根节点的权值，乘上之后就得到x到根节点的权值。
            }
            return parent[x];   //x == parent[x]，说明自己就是根节点，返回。
        }

        //判断/计算x和y的关系。
        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                //x和y在统一集合，根据此并查集的设计，x和y到根节点的权重的比值，就是x和y的比值。
                return weight[x] / weight[y];
            } else {
                //x和y不在同一集合，无法推导出相除的结果，根据题意，返回-1.0d。
                return -1.0d;
            }
        }
    }
}
