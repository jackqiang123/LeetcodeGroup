// Implement a trie with insert, search, and startsWith methods.
//
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
//

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next;
    boolean isWord;
    public TrieNode() {
      next = new TrieNode[26];
      isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
      root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode root, String word, int start){
      if (root == null) {
        root = new TrieNode();
      }
      if (start == word.length()) {
        root.isWord = true;
        return root;
      }
        char c = word.charAt(start);
        root.next[c-'a'] = insert(root.next[c-'a'], word, start + 1);
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
      return search(root, word, 0);
    }

    private boolean search(TrieNode root, String word, int start){
      if (root == null) return false;
      else if (word.length() == start){
        return root.isWord;
      }
      else{
        char c = word.charAt(start);
        return search(root.next[c-'a'], word, start + 1);
      }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
      return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode root, String prefix, int start){
      if (root == null) return false;
      else if (prefix.length() == start)
        return true;
      else {
        char c = prefix.charAt(start);
        return startsWith(root.next[c-'a'], prefix, start + 1);
      }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
