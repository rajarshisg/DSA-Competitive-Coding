/*
   Question Link - https://codeforces.com/problemset/problem/975/C
*/

import java.util.Scanner;
 
public class Main {
    private static int upperBound(long[] arr, int n, long arrows) {
        int low = 0, high = n;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= arrows) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
 
        return low;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            long prefix[] = new long[n];
            
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
                if(i==0){
                    prefix[0] = arr[0];
                }else{
                    prefix[i] = arr[i] + prefix[i-1];
                }
            }
            
            long arrows = 0;
            while(q-->0) {
                long currArrows = sc.nextLong();
                arrows += currArrows;
                
                if(arrows >= prefix[n-1]) {
                    arrows = 0;
                    System.out.println(n);
                }else{
                    int ub = upperBound(prefix, n, arrows);
                    System.out.println(n - ub);
                }
            }
    }
}
