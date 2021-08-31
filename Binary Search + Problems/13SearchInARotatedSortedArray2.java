/* Question Link - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/ */
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        
        int lp = 0, up = nums.length - 1;
        
        while(lp<=up){
            int mid = lp + (up - lp)/2;
            
            if(nums[mid]==target){
                return true;
            }else if(nums[up] == nums[mid] && nums[lp] == nums[mid]) {
                lp++;
                up--;
            }else if(nums[mid]>target && nums[mid]>nums[up] && target<=nums[up]){
                lp = mid + 1;
            }else if(nums[mid]<target && nums[mid]<nums[lp] && target>=nums[lp]){
                up = mid - 1;
            }else if(nums[mid]>target){
                up = mid - 1;
            }else{
                lp = mid + 1;
            }
        }
        
        return false;
    }
}
