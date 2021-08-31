/* Question Link - https://leetcode.com/problems/sqrtx/submissions/ */
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        
        double low = 1, high = x;
        
        while((high - low) >= 1e-6) {
            double mid = low + (high - low) / 2;
            
            if(mid * mid >= x) {
                high = mid;
            }else {
                low = mid;
            }
        }
        
        if(Math.ceil(low) * Math.ceil(low) == x) return (int)Math.ceil(low);
            
        return (int)low;
        
    }
}
