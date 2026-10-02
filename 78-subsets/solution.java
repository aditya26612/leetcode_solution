// 1 ms | 44 MB
class Solution {
        

        void dfs(int[] nums, int start,
         List<Integer> current,
         List<List<Integer>> ans) {

    // 1. save current
        ans.add(new ArrayList<>(current));

    // 2. choices
    for (int i = start; i < nums.length; i++) {

        // choose
        current.add(nums[i]);

        // explore
        dfs(nums,i+1,current,ans);

        // unchoose
        current.removeLast();   
    }
}

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        dfs(nums,0,new ArrayList<>(),ans);

        return ans;
    }
}