// 8 ms | 48.6 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    void dfsPreOrder(TreeNode node, StringBuilder st) {

        if (node == null) {
            st.append("null").append(",");
            return;
        }

        st.append(node.val).append(",");

        dfsPreOrder(node.left, st);
        dfsPreOrder(node.right, st);
        }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st=new StringBuilder();

        dfsPreOrder(root,st);

        return st.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        int[] index = {0};

        // Why int[] index = {0}?

        // This is important Java behavior.

        // Java passes primitive int values by value. If we passed an ordinary int index to recursive calls, each call would receive its own copy.

        // Instead, int[] is an array object. Each recursive call receives a reference to the same array.

        return buildTree(nodes, index);
    }

    private TreeNode buildTree(String[] nodes, int[] index) {

        String value = nodes[index[0]];
        index[0]++;

        if (value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = buildTree(nodes, index);
        node.right = buildTree(nodes, index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));