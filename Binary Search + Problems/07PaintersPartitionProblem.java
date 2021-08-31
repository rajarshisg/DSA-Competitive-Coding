/* Question Link - https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1# */

class Solution{
    static boolean canComplete(int[] arr, int n, int k, long time) {
        int painters = 1;
        long currTime = 0;
        
        for(int i=0;i<n;i++) {
            if(arr[i] > time) return false;
            
            if(arr[i] + currTime > time) {
                painters++;
                currTime = arr[i];
                if(painters > k) return false;
            }else {
                currTime += arr[i];
            }
        }
        
        return true;
    }
    
    static long minTime(int[] arr,int n,int k){
        long maxTime = 0;
        long minTime = 0;
        
        for(int i=0;i<n;i++) {
            maxTime += arr[i];
            minTime = Math.max(minTime, arr[i]);
        }
        
        while(minTime <= maxTime) {
            long currTime = (minTime + maxTime) / 2;
            if(canComplete(arr, n, k, currTime)) {
                maxTime = currTime - 1;
            }else {
                minTime = currTime + 1;
            }
        }
        
        return minTime;
    }
}
