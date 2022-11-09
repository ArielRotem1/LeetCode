class Node{
    String word;
    Node[] childs;
    
    public Node(){
        childs = new Node[26];
        word = "";
    }
}


//Time: O(n*m * 3^L) - n: board height, m: board width, L: maximum length of word in words
//Space: O(words.length*L)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Node root = createTree(words);
        List<String> result = new LinkedList<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                exist(board, root, i, j, result);
            }    
        }
        
        return result;
    }
    
    private Node createTree(String[] words){
        Node root = new Node();
        
        for(String word : words){
            Node temp = root;
            for(int i = 0; i < word.length(); i++){
                int ascii = word.charAt(i) - 'a';
                if(temp.childs[ascii] == null) temp.childs[ascii] = new Node();
                temp = temp.childs[ascii];
            }
            temp.word = word;
        }
        
        return root;
    }
    
    private void exist(char[][] board, Node node, int i, int j, List<String> result) {
        
        //check if found a new word
        if(!node.word.equals("")){
            //add word
            result.add(node.word);
            //mark node as visited so we won't take the word again
            node.word = "";
        }
        
        //out of bounds
        if(i == -1 || i == board.length || j == -1 || j == board[0].length) return;
        
        char ch = board[i][j];
        
        //if visited = ch is '.'
        if(ch == '.') return;
        
        
        Node nextNode = node.childs[ch - 'a'];
        
        //if there is no word that continues with the current letter
        if(nextNode == null) return;
        
        board[i][j] = '.';
        
        exist(board, nextNode, i + 1, j, result);
        exist(board, nextNode, i - 1, j, result);
        exist(board, nextNode, i, j + 1, result);
        exist(board, nextNode, i, j - 1, result);
        
        board[i][j] = ch;
    }
}
