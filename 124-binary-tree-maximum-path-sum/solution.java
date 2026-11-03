// 1 ms | 46.3 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int global;

    int dfs(TreeNode node){
        if(node==null) return 0;

        // if(node.left==null && node.right==null) return node.val;
        // if(node.right==null) return left.right;
        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));


        int value=node.val + left + right;

        if(global <value) global=value;

        return node.val+Math.max(left,right);


    }

    public int maxPathSum(TreeNode root) {
       
        global=root.val;
        dfs(root);

         return global;

    }
}