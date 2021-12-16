import java.util.Hashtable;

class Solution {
    private Hashtable<Integer,Integer> ht;
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        ht = new Hashtable<>();
        
        int productOfAll = 1;
        int productOfAllButZero = 1;
        int zeros = 0;
        int indexZero = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                indexZero = i;
                zeros++;
                if(zeros > 1){
                    return answer;
                }
            }
            else{
                productOfAllButZero *= nums[i];
            }
            
            productOfAll *= nums[i];
        }
        
        if(zeros == 1){
            answer[indexZero] = productOfAllButZero;
            return answer;
        }
        
        //System.out.println("productOfAll: " + productOfAll);
        
        for(int i = 0; i < answer.length; i++){
            if(ht.containsKey(nums[i])){
                answer[i] = ht.get(nums[i]);
            }
            else{
                answer[i] = Divide(productOfAll, nums[i]);
                ht.put(nums[i], answer[i]);
            }
        }
        
        return answer;
    }
    
    private int Divide(int productOfAll, int value){
        int result = 0;
        
        if(productOfAll > 0){
            if(value > 0){
                while(productOfAll > 0){
                    productOfAll -= value;
                    result++;
                }
            }
            else{
                while(productOfAll > 0){
                    productOfAll += value;
                    result--;
                }
            }
            return result;
        }
        else{
            if(value > 0){
                while(productOfAll < 0){
                    productOfAll += value;
                    result--;
                }
            }
            else{
                while(productOfAll < 0){
                    productOfAll -= value;
                    result++;
                }
            }
            return result;
        }
        
        
    }
}