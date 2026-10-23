// 2 ms | 48.2 MB
// Recursion
// class Solution {

//     int re(int n){
//         if(n==0){
//             return 0;
//         }
//         return re(n>>1) + (n&1);
//     }

//     public int[] countBits(int n) {
//         int[] ar=new int[n+1];
        
//         for(int i=0;i<=n;i++){
//             ar[i]=re(i);
//         }

//         return ar;
//     }
// }

class Solution {


    public int[] countBits(int n) {
        int[] ar=new int[n+1];
        
        for(int i=0;i<=n;i++){
            ar[i]=ar[i>>1] + (i&1);
        }

        return ar;
    }
}