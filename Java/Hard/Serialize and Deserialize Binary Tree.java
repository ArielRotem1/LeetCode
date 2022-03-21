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
    
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }
    
    private void serializeDFS(TreeNode node, StringBuilder sb){
        
        if(node == null){
            sb.append("n");
            return;
        }
        
        sb.append(node.val + ",");
        serializeDFS(node.left, sb);
        sb.append(",");
        serializeDFS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        return deserializeDFS(data.split(","));
    }
    
    
    private TreeNode deserializeDFS(String[] array){
        
        String currStr = array[index];
        index++;
        
        if(currStr.equals("n")) return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(currStr));
        
        node.left = deserializeDFS(array);
        node.right = deserializeDFS(array);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));