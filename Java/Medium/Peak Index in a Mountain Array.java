
class Solution {
    //Time: O(log(n)) - n: arr.length
    //Space: O(1)
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while(left < right){
            int mid = (right - left) / 2 + left;

            //the peak is to the right
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }
            //the peak is to the left
            else if(arr[mid] < arr[mid - 1]){
                right = mid - 1;
            }
            else return mid;
        }

        return right;
    }
}
