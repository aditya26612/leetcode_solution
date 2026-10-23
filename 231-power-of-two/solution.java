// 2 ms | 41.6 MB
class Solution {
    public boolean isPowerOfTwo(int n) {


        if(n>0 && (n&(n-1))==0){
            return true;
        }
        return false;
    }
}