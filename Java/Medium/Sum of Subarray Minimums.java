class Solution {
    //Time: O(n) - n:arr.length
    //Space: O(n)
    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        long currSum = 0;
        int mod = 1_000_000_007;
        if(arr.length == 1) return arr[0] % mod;
        
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> startIndex = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];

            int prevIndex = 0;
            
            while(!nums.isEmpty() && nums.peek() > num){
                int numOut = nums.pop();
                int indexOut = startIndex.pop();
                int prevNumIndex = 0;
                if(!startIndex.isEmpty()) prevNumIndex = startIndex.peek() + 1;
                currSum -= (numOut * (indexOut - prevNumIndex + 1));
            }
            
            if(!nums.isEmpty()) prevIndex = startIndex.peek() + 1;

            nums.push(num);
            startIndex.push(i);
            currSum += num * (i - prevIndex + 1);
            
            result = (result + (int) (currSum % mod)) % mod;
        }

        return result;
    }
}
