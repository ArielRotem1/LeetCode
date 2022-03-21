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
    public static List<Integer> outputArray;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        outputArray = new ArrayList<Integer>();
        getLeafNodes(root1);
        List<Integer> leafNodesTree1 = outputArray;
        
        outputArray = new ArrayList<Integer>();
        getLeafNodes(root2);
        List<Integer> leafNodesTree2 = outputArray;

        return isSame(leafNodesTree1, leafNodesTree2);
    }
    
    private boolean isSame(List<Integer> leafNodesTree1, List<Integer> leafNodesTree2){
        if(leafNodesTree1.size() != leafNodesTree2.size()) return false;
        
        for(int i = 0; i < leafNodesTree1.size(); i++){
            if(leafNodesTree1.get(i) != leafNodesTree2.get(i)) return false;
        }
        
        return true;
    }
    
    private void getLeafNodes(TreeNode treeNode){
        if(hasChilds(treeNode) == false){
            outputArray.add(treeNode.val);
            return;
        }
        
        if(treeNode.left != null) getLeafNodes(treeNode.left);
        if(treeNode.right != null) getLeafNodes(treeNode.right);
    }
    
    private boolean hasChilds(TreeNode treeNode){
        return treeNode.right != null || treeNode.left != null;
    }
}
