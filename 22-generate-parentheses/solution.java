// 1 ms | 44.2 MB
class Solution {

    // private void dfs(List<String> ans,StringBuffer current,int open,int close,int n) {
        
    //     if(open==n && close==n){
    //         ans.add(current.toString());
    //         return;
    //     }

    //     if(open < n){
    //         current.append('(');
    //         open++;

    //         dfs(ans,current,open,close,n);

            
    //         current.deleteCharAt(current.length() - 1);
    //         open--;
    //     }
        

    //     if(close < open){
    //         current.append(')');
    //         close++;

    //         dfs(ans,current,open,close,n);

    //         current.deleteCharAt(current.length() - 1);
    //         close--;
    //     }
    //     return ;
    // }


    private void dfs(List<String> ans,StringBuffer current,int open,int close,int n) {
        
        if(open==n && close==n){
            ans.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');
            dfs(ans,current,open+1,close,n);         
            current.deleteCharAt(current.length() - 1);
        }
        

        if(close < open){
            current.append(')');
             dfs(ans,current,open,close+1,n);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ans=new ArrayList<>();

        dfs(ans,new StringBuffer(),0,0,n);

            return ans;
    }

    
}