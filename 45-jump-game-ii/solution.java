// 2 ms | 46.9 MB
class Solution {
    public int jump(int[] nums) {
        
        if(nums.length==1) return 0;

        int far=0;
        int jump=0;

        int currentBoundaryEnd=0;

        for(int i=0;i<nums.length;i++){

            far=Math.max(far,i+nums[i]);
            
            if(i==currentBoundaryEnd){
                jump++;
                currentBoundaryEnd=far;
            }
            
            if(currentBoundaryEnd==nums.length-1){
                break;
            }

        }
            return jump;
    }
}