import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashSet;

class Node{
    int val;
    int nodesVisited;
    
    public Node(int val, int nodesVisited){
        this.val = val;
        this.nodesVisited = nodesVisited;
    }
}

class Solution {
    
    public int shortestPathLength(int[][] graph) {
        Queue<Node> que = new ArrayDeque();
        
        for(int i = 0; i < graph.length; i++)
            que.add(new Node(i, 1 << i));
        
        int endMask = (1 << graph.length) - 1;
        boolean[][] moveFromTo = new boolean[graph.length][endMask];
        
        int steps = 0;
        
        while(!que.isEmpty()){
            Queue<Node> nextQueue = new ArrayDeque<>();
            while(!que.isEmpty()){
                Node currNode = que.poll();

                for(int nodeToGoTo : graph[currNode.val]){
                    int nextNodesVisited = currNode.nodesVisited | (1 << nodeToGoTo);
                    if (nextNodesVisited == endMask) {
                        return 1 + steps;
                    }
                    
                    if(!moveFromTo[nodeToGoTo][nextNodesVisited]){
                        moveFromTo[nodeToGoTo][nextNodesVisited] = true;
                        nextQueue.add(new Node(nodeToGoTo, nextNodesVisited));
                    }
                }
            }
            steps++;
            que = nextQueue;
        }
        
        return 0;
    }
}
