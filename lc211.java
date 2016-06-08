// Design a data structure that supports the following two operations:
//
// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//
// For example:
//
// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.
//
// click to show hint.
//
// You should be familiar with how a Trie works. If not, please work on this problem:
// Implement Trie (Prefix Tree) first.

public class WordDictionary {
    Trie dict = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
      dict.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
      return dict.search(word);
    }
}
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

class Trie {
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
        if (c != '.')
          return search(root.next[c-'a'], word, start + 1);
        else {
          for (int i = 0; i < 26; i++)
          {
            if (search(root.next[i], word, start + 1))
              return true;
          }
        }
        return false;
      }
    }
}
