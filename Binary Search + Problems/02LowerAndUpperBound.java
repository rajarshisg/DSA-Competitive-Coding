/* 
   Question Link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    
    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) high = mid - 1;
            if(nums[mid] < target) low = mid + 1;
        }
        
        if(low >= nums.length || nums[low] != target) return -1;
        return low;
    }
    
    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target) low = mid + 1;
            if(nums[mid] > target) high = mid - 1;
        }
        
        if(high < 0 || nums[high] != target) return -1;
        return high;
    }
    
    
    public int[] searchRange(int[] nums, int target) {       
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        
        int[] arr = new int[2];
        arr[0] = lb;
        arr[1] = ub;
        return arr;
    }
}
