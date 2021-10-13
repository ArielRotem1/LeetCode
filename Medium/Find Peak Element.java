/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    let l = 0, r = nums.length - 1;
    
    while(l + 1 < r){
        let m = l + Math.floor((r - l) / 2)
        
        let a = nums[m];
        let b = nums[l];
        let c = nums[r];
        
        if(c <= a && nums[m - 1] > a){
            r = m;
        }
        else if(b <= a && nums[m + 1] > a){
            l = m;
        }
        else if(c < a || b < a){
            return m;
        }
        else{
            if(nums[l] < nums[r]) 
                l = m;
           else r = m;
        }
    }
    
    if(nums[l] < nums[r]) return r;
        
    return l;
}
