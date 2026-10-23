// 0 ms | 46.6 MB
class Solution {
    public int missingNumber(int[] nums) {
         int ans=0^nums[0];
         for(int i=1;i<nums.length;i++){
            ans^=i^nums[i];
         }
           ans=ans^nums.length;
         return ans;
    }
}