// 18 ms | 98.1 MB
class Solution {

    void dfs(int n,int start,List<List<Integer>> ans,List<Integer> current,int k){

        if(current.size()==k){
        ans.add(new ArrayList<>(current));
        return;
        }

        for(int i=start;i<=n;i++){


            current.add(i);
            dfs(n,i+1,ans,current,k);
            current.removeLast();

        }
    }


    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();

        dfs(n,1,ans,new ArrayList<>(),k);

        return ans;
    }
}