/* Question Link - https://leetcode.com/problems/find-the-duplicate-number/ */
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) count++;
            }
            
            if(count > mid) {
                //by pigeonhole principle one number must have appeared twice in 1 to mid
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
