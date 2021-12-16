/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Stack<TreeNode> stackP = new Stack();
        int depthP = getDepth(root, p, 0, stackP);
        Stack<TreeNode> stackQ = new Stack();
        int depthQ = getDepth(root, q, 0, stackQ);
        
        int diffDepth = depthQ - depthP;
        
        while(diffDepth > 0){
            diffDepth--;
            stackQ.pop();
        }
        
        while(diffDepth < 0){
            diffDepth++;
            stackP.pop();
        }
        
        TreeNode nodePStack = stackP.pop();
        
        while(nodePStack.val != stackQ.pop().val){
            nodePStack = stackP.pop();
        }
        
        return nodePStack;
    }
    
    private int getDepth(TreeNode node, TreeNode searchedNode, int depth, Stack
        <TreeNode> stack){
        
        stack.push(node);
        
        if(node.val == searchedNode.val) return depth;
        
        if(node.left != null){
            int res = getDepth(node.left, searchedNode, depth + 1, stack);
            if(res != -1) return res;
            stack.pop();
        }
        
        if(node.right != null){
            int res = getDepth(node.right, searchedNode, depth + 1, stack);
            if(res != -1) return res;
            stack.pop();
        }
        
        return -1;
    }
}