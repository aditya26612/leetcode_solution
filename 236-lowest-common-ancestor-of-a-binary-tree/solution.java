// 18 ms | 70 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode lca(TreeNode node,TreeNode p, TreeNode q){

        if(node==null) return null;

        if(node==p || node==q){
            return node;
        }

        TreeNode left=lca(node.left,p,q);
        TreeNode right=lca(node.right,p,q);

        if(left!=null && right!=null) return node;

        else if(left!=null) return left;
        else return right;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lca(root,p,q);
    }
}