/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char[]buffer= new char[4];
        int readlen = 0;
        while(readlen < n && !eof){
            int curread = read4(buffer);
            if(curread != 4) eof = true;
            int len = Math.min(curread, n - readlen);
            for(int i = 0; i< len ;i++){
                 buf[readlen+i]=buffer[i] ;
            }
            readlen += len;
        }
        return readlen;
    }
}
