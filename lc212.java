// Given a 2D board and a list of words from the dictionary, find all words in the board.
//
// Each word must be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once in a word.
//
// For example,
// Given words = ["oath","pea","eat","rain"] and board =
//
// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// Return ["eat","oath"].
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
//
public class Solution {
    Trie dict;
    List<String> res;
    boolean visit[][];
    public List<String> findWords(char[][] board, String[] words) {
      dict = new Trie();
      res = new ArrayList<String>();
      int h = board.length;
      int w = board[0].length;
      visit = new boolean[h][w];
      for (String s : words){
        dict.insert(s);
      }
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++)
        {
          dfs(board, i, j, new StringBuilder());
        }
      }
      return res;
    }

    private void dfs(char[][]board, int i, int j, StringBuilder cur){
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j])
        return;
      cur.append(board[i][j]);
      if (dict.startsWith(cur.toString())) {
          if (dict.search(cur.toString())) {
            if (!res.contains(cur.toString())) res.add(cur.toString());
          }
          visit[i][j] = true;
          dfs(board, i - 1, j, cur);
          dfs(board, i + 1, j, cur);
          dfs(board, i, j - 1, cur);
          dfs(board, i, j + 1, cur);
          visit[i][j] = false;
      }
      cur.deleteCharAt(cur.length() - 1);
    }
}


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
