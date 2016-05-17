// The API: int read4(char *buf) reads 4 characters at a time from a file.
//
// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
// Note:
// The read function may be called multiple times.
public class Solution extends Reader4 {
    /**
      * @param buf Destination buffer
      * @param n   Maximum number of characters to read
      * @return    The number of characters read
      */
      private char buffer = new char[4];
      private int oneRead = 0;
      private int offset = 0;

     public int read(char[] buf, int n) {


}
}
