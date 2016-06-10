// The API: int read4(char *buf) reads 4 characters at a time from a file.
//
// The return value is the actual number of characters read. For example,
// it returns 3 if there is only 3 characters left in the file.
//
// By using the read4 API, implement the function int read(char *buf, int n)
// that reads n characters from the file.
//
// Note:
// The read function may be called multiple times.
public class Solution extends Reader4 {
    /**
      * @param buf Destination buffer
      * @param n   Maximum number of characters to read
      * @return    The number of characters read
      */
     private int size = 0; // this is a pointer to pick up the last reading pos
     private char [] buf4 = new char[4];
     public int read(char[] buf, int n) {
       boolean eof = false;
       char[] buf4 = new char[4];
       int beginSize = size;
       while(!eof){
         int curSize = read4(buf4);
         if (curSize != 4)
           eof = true;
         for (int i = 0; i < curSize && (size - beginSize) < n; i++)
           buf[size++] = buf4[i];
       }
       return size - beginSize;
       }
     }
}
