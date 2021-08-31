/* Question Link - https://leetcode.com/problems/find-peak-element/ */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int left = (mid > 0)? nums[mid - 1] : Integer.MIN_VALUE;
            int right = (mid < nums.length - 1)? nums[mid + 1] : Integer.MIN_VALUE;
            
            if(nums[mid] > left && nums[mid] > right) return mid;
            if(nums[mid] <= left && nums[mid] > right) high = mid - 1;
            if(nums[mid] <= right) low = mid + 1;
        }
        
        return -1;
    }
}
