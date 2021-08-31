/* Question Link - https://leetcode.com/problems/search-in-rotated-sorted-array/ */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target && nums[mid] > nums[high] && target < nums[low]) {
                low = mid + 1;
            }else if(nums[mid] < target && nums[mid] < nums[low] && target >= nums[low]) {
                high = mid - 1;
            }else if(nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}
