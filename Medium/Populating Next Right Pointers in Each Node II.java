/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    private Node currentNode;
    private int depth;
    public Node connect(Node root) {
        if(root == null) return null;
        
        currentNode = null;
        depth = 1;
        
        boolean res = DFS(root, 0);
        while(res){
            depth++;
            currentNode = null;
            res = DFS(root, 0);
        }
        
        
        return root;
    }
    
    private boolean DFS(Node currNode, int currDepth){
        if(currDepth == depth){
            if(currentNode == null){
                currentNode = currNode;
            }
            else{
                currentNode.next = currNode;
                currentNode = currentNode.next;
            }
            return true;
        }
        
        boolean resultLeft = false, resultRight = false;
        
        if(currNode.left != null){
            resultLeft = DFS(currNode.left, currDepth + 1);
        }
        
        if(currNode.right != null){
            resultRight = DFS(currNode.right, currDepth + 1);
        }
        
        return resultLeft || resultRight;
    }
}
