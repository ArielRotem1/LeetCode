//I have chosen ArrayList over Doubly linked list because of the following:
//1) "visit" in linked is faster because it is actually O(1) time and you can erase the forward history
//   more easly but ArrayList is also O(1) time (amortized) and you can use "maxIndex" to "erase" the forward history.
//   **So Doubly linked list has little more advantage than ArrayList.**
//2) "back" and "forward" in linked is slower because you need to pass every node in the list in order to reach
//   the wanted node which is O(n) but in ArrayList you can just jump to the wanted index O(1).
//   **So ArrayList has much more advantage than Doubly linked list.**

class BrowserHistory {
    
    //Space: O(n) - n: number of pages visited
    List<String> history;
    int currentIndex;
    int maxIndex;

    //Time: O(1)
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        currentIndex = 0;
        maxIndex = 0;
        history.add(homepage);
    }
    
    //Time: O(1)
    public void visit(String url) {
        
        //front of history
        if(currentIndex == history.size() - 1){
            history.add(url);
            currentIndex++;
            maxIndex++;
            return;
        }
        
        //not front of history
        //(which surely means that we went back in history)
        //which means that now we erasing the forward history
        currentIndex++;
        maxIndex = currentIndex;
        history.set(currentIndex, url);
    }
    
    //Time: O(1)
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }
    
    //Time: O(1)
    public String forward(int steps) {
        currentIndex = Math.min(maxIndex, currentIndex + steps);
        return history.get(currentIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
