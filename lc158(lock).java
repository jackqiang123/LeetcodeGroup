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
     private int bufPointer = 4;
     private int resPointer = 0;
     private int maxBuffer = 0;
     private char [] buf4 = new char[4];
     private boolean eof = false;
     public int read(char[] buf, int n) {
         resPointer = 0;
         int beginSize = resPointer;
         while(!(eof == true && bufPointer >= maxBuffer)){
           if (bufPointer == 4){
             maxBuffer = read4(buf4);
             if (maxBuffer < 4) eof = true;
             bufPointer = 0;
           }
           while(bufPointer < maxBuffer && n > 0){
             buf[resPointer++] = buf4[bufPointer++];
             n--;
           }
           if (n == 0) break;
         }
         return resPointer - beginSize;
     }
}
