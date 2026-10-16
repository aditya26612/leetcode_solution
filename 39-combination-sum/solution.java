// 2 ms | 45.3 MB
class Solution {


    void dfs(int[] candidates,int rem,int startIndex,List<Integer> current,
             List<List<Integer>> ans){

        if(rem==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        else if(rem<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            rem-=candidates[i];

            current.add(candidates[i]);

            dfs(candidates,rem,i,current,ans);

            rem+=candidates[i];

            current.remove(current.size()-1);
        }
            return ;
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        

        dfs(candidates,target,0,new ArrayList<>(),ans);

        return ans;

    }
   
}