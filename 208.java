class TrieNode {
    // Initialize your data structure here.
    TrieNode[]next;
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

    private TrieNode insert(TrieNode root, String word, int index){
      if (root == null) root = new TrieNode();
      if (index == word.length()) {
        root.isWord = true;
        return root;
      }
      else {
       root.next[word.charAt(index)-'a'] = insert(root.next[word.charAt(index)-'a'], word, index + 1);
       return root;
      }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
      return search(root, word, 0);
    }
    private boolean search(TrieNode root, String word, int index){
      if (root == null) return false;
      if (word.length() == index) return root.isWord;
      return search(root.next[word.charAt(index)-'a'], word, index + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
      return prefix(root, word, 0);
    }
    private boolean prefix(TrieNode root, String word, int index){
      if (root == null) return false;
      if (index == word.length()) return root != null;
      return prefix(root.next[word.charAt(index)-'a'], word, index + 1);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
