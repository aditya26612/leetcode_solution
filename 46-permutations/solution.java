// 1 ms | 45.8 MB
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        // Start backtracking here
        dfs(nums,0,new ArrayList<>(),used,ans);

        return ans;
    }

    void dfs(int[] nums,int start,List<Integer> current,boolean[] used,List<List<Integer>> ans
    ) {
        
        if(current.size()==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=start;i<nums.length;i++ ){

            if(used[i]==true) {
                continue;
            }
            
           current.add(nums[i]);
            used[i] = true;

            dfs(nums, 0, current, used, ans);

            current.remove(current.size() - 1);
            used[i] = false;
            
        }
    }
}