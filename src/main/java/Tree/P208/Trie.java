package Tree.P208;

/*
官方题解，字典树。
https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode-ti500/
每一个节点有一个子节点数组，代表可能的26个英文字母；还有一个布尔变量isEnd，代表是否到当前节点为止的字符串，是否是一个曾经插入的完整单词。

时间复杂度：初始化为O(1)，其他操作为O(L)，L表示字符串的长度                                                                                                                                                     打败91.23%
空间复杂度：O(T*S)，T为所有插入的字符串长度之和，S为字符集大小，这里为26。最坏情况下，所有字符串都没有共同前缀，则每个字符都对应一个节点，每个节点又有一个长为S的子节点数组。所以空间复杂度为O(T*S)                 打败86.39%
*/

class Trie {
    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);     //先利用searchPrefix查找是否存在该字符串
        return node != null && node.isEnd;      //若存在，并且是曾插入的完整单词，返回true。
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;        //利用searchPrefix查找是否存在该字符串，存在就说明有这个前缀。
    }

    //查找字典树中是否存在某字符串（不论是否为完整单词）；若存在，则直接返回该字符串在字典树中的末尾节点。
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) return null;   //搜索中断，直接返回。
            node = node.children[index];
        }
        return node;
    }

    //节点内部类
    class TrieNode {
        TrieNode[] children;    //子节点数组
        boolean isEnd;      //是否为完整单词

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
