// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
//
// For example, given the following image:
//
// [
//   "0010",
//   "0110",
//   "0100"
// ]
// and x = 0, y = 2,
// Return 6.
public class Solution{
   public int minArea(char[][] image, int x, int y) {
     int h = image.length;
     int w = image[0].length;
     int xstart = findLeft(image, x, true);
     int xend = findRight(image, x, true);
     int ystart = findLeft(image, y, false);
     int yend = findRightimage, y, false);
     return (xend - xstart + 1)*(yend - ystart + 1);
   }

   private findLeft(char[][]image, int x, boolean checkRow){
     int lo = 0;
     int hi = x;
     while(lo < hi){
       int mid = (lo + hi)/2;
       if (checkRow(mid) == true && checkRow || !checkRow && checkCol(mid)){
         hi = mid;
       }
       else lo = mid + 1;
     }
     return lo;
   }

   private findRight(char[][]image, int x, boolean checkRow){
     int lo = x;
     int hi = image.length - 1;
     while(lo < hi){
       int mid = (lo + hi)/2;
       if (checkRow(mid) && checkRow || !checkRow && checkCol(mid)){
          lo = mid + 1;
       }
       else hi = mid;
     }
     return lo == x ? lo : lo - 1;
   }

   private boolean checkRow(char[][]image, int row){
     for (int j = 0; j < image[0].length; j++){
       if (image[row][j] == '1')
        return true;
     }
     return false;
   }
   private boolean checkCol(char[][]image, int col){
     for (int j = 0; j < image.length; j++){
       if (image[j][col] == '1')
        return true;
     }
     return false;
   }

 }
