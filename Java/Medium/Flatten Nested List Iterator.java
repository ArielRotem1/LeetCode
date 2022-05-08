/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.ArrayDeque;
import java.util.List;
public class NestedIterator implements Iterator<Integer> {
    
    ArrayDeque<List<NestedInteger>> stack;
    ArrayDeque<Integer> stackIndicis;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(nestedList);
        
        stackIndicis = new ArrayDeque<>();
        stackIndicis.push(0);
        
        getNext();
    }

    @Override
    public Integer next() {
        List<NestedInteger> nestedIntegerList = stack.pop();
        Integer index = stackIndicis.pop();
        stack.push(nestedIntegerList);
        stackIndicis.push(index);
        
        
        Integer returnedInteger = nestedIntegerList.get(index - 1).getInteger();
        getNext();
        return returnedInteger;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void getNext(){
        
        while(!stack.isEmpty()){
            List<NestedInteger> nestedIntegerList = stack.pop();
            Integer index = stackIndicis.pop();
            
            
            for(int i = index; i < nestedIntegerList.size(); i++){
                NestedInteger nestedInteger = nestedIntegerList.get(i);
                stack.push(nestedIntegerList);
                stackIndicis.push(i + 1);
                
                if(nestedInteger.isInteger()) return;
                else{
                    stack.push(nestedInteger.getList());
                    stackIndicis.push(0);
                    break;
                }
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
