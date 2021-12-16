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
    private static TreeNode root;
    public static TreeNode deleteNode(TreeNode node, int key){
        root = node;
        
        deleteNode(node, key, null, 0);
        
        return root;
    }
    
    private static void deleteNode(TreeNode node, int key, TreeNode parent, int 
        dir){
        if(node == null) return;
        
        if(node.val > key){
            //go left
            deleteNode(node.left, key, node, -1);
        }
        else if(node.val < key){
            //go right
            deleteNode(node.right, key, node, 1);
        }
        else{ //node.val == key
            //I found the node to remove!
            
            if(node.left == null && node.right == null){
                if(dir == -1) //went left
                    parent.left = null;
                else if(dir == 1) //went right
                    parent.right = null;
                else //no parent
                    root = null;
                return;
            }
            
            if(node.left == null){
                if(dir == -1) //went left
                    parent.left = node.right;
                else if(dir == 1) //went right
                    parent.right = node.right;
                else //no parnet
                    root = node.right;
                return;
            }
            
            if(node.right == null){
                if(dir == -1) //went left
                    parent.left = node.left;
                else if(dir == 1) //went right
                    parent.right = node.left;
                else //no parnet
                    root = node.left;
                return;
            }
            
            TreeNode leftChild = node.left;
                
            if(dir == -1) //went left
                parent.left = leftChild;
            else if(dir == 1) //went right
                parent.right = leftChild;
            
            TreeNode nodeToAdd = leftChild.right;
            
            leftChild.right = node.right;
            //I have cut him out!
            
            if(dir == 0){ //no parnet
                root = leftChild;
                parent = leftChild;
            }
            
            //I will add the node to the tree
            if(nodeToAdd != null) addNode(parent, nodeToAdd);
        }
    }
    
    private static void addNode(TreeNode node, TreeNode nodeToAdd){
        if(node.val < nodeToAdd.val){
            //go right
            if(node.right != null)
                addNode(node.right, nodeToAdd);
            else
                node.right = nodeToAdd;
        }
        else if(node.val > nodeToAdd.val){
            //go left
            if(node.left != null)
                addNode(node.left, nodeToAdd);
            else
                node.left = nodeToAdd;
        }
    }
}