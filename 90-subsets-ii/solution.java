// 12 ms | 44.7 MB
class Solution {

    void dfs(int[] nums,int start,List<List<Integer>> ans,List<Integer> current){

        if(!ans.contains(current)){
        ans.add(new ArrayList<>(current));
        }

        for(int i=start;i<nums.length;i++){

            if(i>start+1 && current.equals(nums[i])){
                continue;
            }

            current.add(nums[i]);
            dfs(nums,i+1,ans,current);
            current.removeLast();

        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums,0,ans,new ArrayList<>());

        return ans;


    }
}