/* Question Link - https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559 */

import java.util.*;

public class Solution 
{
    private static boolean isPossibleToPlaceCows(ArrayList<Integer> stalls, int distance, int k) {
        int cows = 1;
        int pos = stalls.get(0);
        for(int i=1;i<stalls.size();i++) {
            if(stalls.get(i) - pos >= distance) {
                cows++;
                pos = stalls.get(i);
            }
            
            if(cows == k) return true;
        }
        
        return false;
    }
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
     	Collections.sort(stalls);
        int n = stalls.size();
        int low = 1, high = stalls.get(n - 1) - stalls.get(0);
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            boolean res = isPossibleToPlaceCows(stalls, mid, k);
            if(res) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}
