// 135 ms | 42.5 MB
class Solution {
    int r,c;
    boolean[][] visited;
    boolean ans=false;

    void dfs(int row,int col,int index,char[][] board, String word){


        if((row < 0 || row >= r)||(col < 0 || col >= c)){
            return ;
        }

        if(visited[row][col]==true){
            return;
        }

        if(board[row][col]!=word.charAt(index)){
            return;
        }

        if(index==word.length()-1){
            ans=true;
            return;
        }

        

        visited[row][col]=true;
        index++;
        dfs(row-1,col,index,board, word);
        dfs(row,col-1,index,board, word);
        dfs(row+1,col,index,board, word);
        dfs(row,col+1,index,board, word);

        // if(ans==true) return;
        visited[row][col]=false;

    }

    public boolean exist(char[][] board, String word) {
        r=board.length;
        c=board[0].length;

        visited=new boolean[r][c];

        
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(i,j,0,board,word);
            }
        }


        return ans;
    }
}