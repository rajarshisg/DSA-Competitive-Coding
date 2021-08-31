/* Question Link - https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1# */

class Solution 
{
    private static boolean isPossibleToAllocatePages(int[] arr, int n, int m, int pages) {
        int students = 1;
        int currPages = 0;
        for(int i=0;i<n;i++) {
            if(arr[i] > pages) return false;
            if(currPages + arr[i] > pages) {
                students++;
                currPages = arr[i];
                if(students > m) return false;
            }else{
                currPages += arr[i];
            }
        }
        
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[] arr,int n,int m)
    {
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        
        int low =  min, high = sum;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossibleToAllocatePages(arr, n, m, mid) == true) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return low;
    }
};
