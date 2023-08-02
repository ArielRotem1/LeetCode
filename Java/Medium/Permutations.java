//Time: O(n! * n) - n: nums.length,  
//Space: O(n! * n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(result, nums, 0, new LinkedList<Integer>());
        return result;
    }

    void permute(List<List<Integer>> result, int[] nums, int numbersSeen, List<Integer> curr){

        if(curr.size() == nums.length){
            result.add(new LinkedList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if((numbersSeen & (1 << i)) > 0) continue;

            curr.add(num);
            numbersSeen |= 1 << i;
            permute(result, nums, numbersSeen, curr);
            numbersSeen &= ~(1 << i);
            curr.remove(curr.size() - 1);
        }
    }
}
