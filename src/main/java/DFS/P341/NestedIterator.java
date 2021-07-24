package DFS.P341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 /*
官方题解，方法一，dfs。
https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/bian-ping-hua-qian-tao-lie-biao-die-dai-ipjzq/
题目所给的数据结构，显然是一个树的形式。可以用dfs的方式先遍历该数据结构，取出所有数据存储到一个List里，然后对该List进行hasNext和next操作即可。

时间复杂度：next和hasNext都是O(1)，初始化为O(N)，因为需要dfs遍历，得到所有元素。            打败96.93%
空间复杂度：O(N)，vals的大小。                                                          打败39.68%
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;         //存储遍历到的数据
    private Iterator<Integer> iter;     //vals的迭代器


    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        iter = vals.iterator();
    }

    private void dfs(List<NestedInteger> nestedList){   //dfs，遍历所有数据，添加到vals中。
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()){               //是数字就添加到vals中。
                vals.add(nest.getInteger());            }
            else{                             //不是数字，那就是列表，进一步dfs。
                dfs(nest.getList());
            }
        }
    }

    @Override
    public Integer next() {         //直接调用vals的迭代器的next和hasNext即可。
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
