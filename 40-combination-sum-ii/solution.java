// 8 ms | 44.9 MB

class Solution {


    void dfs(int[] candidates,int rem,int startIndex,List<Integer> current,
             List<List<Integer>> ans){

        if(rem==0){
            if(!ans.contains(current)){
            ans.add(new ArrayList<>(current));
            }
            return;
        }
        else if(rem<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){

            if(i > startIndex && candidates[i]==candidates[i-1]){
                continue;
            }

            rem-=candidates[i];

            current.add(candidates[i]);

            dfs(candidates,rem,i+1,current,ans);

            rem+=candidates[i];

            current.remove(current.size()-1);
        }
            return ;

             }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(candidates);

        dfs(candidates,target,0,new ArrayList<>(),ans);

        
        return ans;

    }


    
   
}