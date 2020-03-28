class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> map = new HashMap<>();
        for (String word : words) {
            int i = word.length() - 1;
            TrieNode node = root.get(word.charAt(i));
            for (--i; i >= 0; --i) {
                node = node.get(word.charAt(i));
            }
            map.put(node, word.length() + 1);
        }
        int result = 0;
        for (TrieNode node : map.keySet()) {
            if (node.isLeaf) {
                result += map.get(node);
            }
        }
        return result;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;
    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = true;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            isLeaf = false;
        }
        return children[c - 'a'];
    }
}
