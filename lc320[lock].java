
    // Write a function to generate the generalized abbreviations of a word.
    //
    // Example:
    // Given word = "word", return the following list (order does not matter):
    //
    // ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    //

    public class Solution {
        List<String> res;
        public List<String> generateAbbreviations(String word) {
          res = new ArrayList();
          dfs(word, new StringBuilder(), 0, 0);
          return res;
        }

        private void dfs(String word, StringBuilder cur, int start, int num){
          int len = cur.length();
          if (start == word.length()){
            if (num != 0) res.append(num);
              res.add(cur.toString());
          }
          else {//it is like generating
            dfs(word, cur, start + 1, num + 1); // make it abbreivation
            if (num != 0) cur.append(num); // NOT make it abbreivation
            dfs(word, cur.append(word.charAt(start)) , start + 1, 0); //thus append current char there.
          }
          cur.setLength(len); //backtrack
        }
    }
