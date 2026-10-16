// 2 ms | 45.4 MB
class Solution {


    void dfs(int[] candidates,int rem,int startIndex,List<Integer> current,
             List<List<Integer>> ans,int target){

        if(rem==0){
            ans.add(new ArrayList<>(current));
            rem=target;
            return;
        }
        else if(rem<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            rem-=candidates[i];

            current.add(candidates[i]);

            dfs(candidates,rem,i,current,ans,target);

            rem+=candidates[i];

            current.remove(current.size()-1);
        }
            return ;
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        

        dfs(candidates,target,0,new ArrayList<>(),ans,target);

        return ans;

    }
   
}