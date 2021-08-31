/* Question Link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ */
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            
            if(nums[mid] >= nums[low] && nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return nums[low];
    }
}
