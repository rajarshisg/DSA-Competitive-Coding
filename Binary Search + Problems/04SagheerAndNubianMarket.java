/* Question Link - https://codeforces.com/contest/812/problem/C */

import java.util.*;
 
public class Main {
    private static long costNeeded(long[] prices, long items) {
        long[] currPrice = new long[prices.length];
        for(int i=0;i<prices.length;i++) {
            currPrice[i] = prices[i] + (i + 1) * items;
        }
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<prices.length;i++) {
            maxHeap.add(currPrice[i]);
            if(maxHeap.size() > items){
                maxHeap.poll();
            }
        }
        
        long cost = 0;
        while(!maxHeap.isEmpty()) {
            cost += maxHeap.poll();
        }
        
        return cost;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long budget = sc.nextLong();
        long[] prices = new long[n];
        long totalPrice = 0;
        for(int i=0;i<prices.length;i++) {
            prices[i] = sc.nextLong();
        }
        
        int low = 1, high = n;
        long cost = 0, numItems = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            long currCost = costNeeded(prices, mid);
            if(currCost <= budget) {
                numItems = mid;
                cost = currCost;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        System.out.println(numItems + " " + cost);
    } 
}
