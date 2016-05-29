public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long len = 0,height = 0;
        len = (long)Math.min(C,G) - (long)Math.max(A,E);
        if(len < 0) len = 0;
        height = (long)Math.min(D,H) - (long)Math.max(B,F);
        if(height < 0) height = 0;
        long area = (long)(C-A)*(D-B) + (long)(H-F)*(G-E) - (long)height*len;
        return (int)area;
    }
}
