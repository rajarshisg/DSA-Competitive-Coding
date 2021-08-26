class Solution {
    public int maxProfit(int[] prices) {
        /* For One Transaction we need to buy the stock on the day it has minimum value and sell on the day it has maximum */
        /* For Two transactions we can partition at every given day and find the max of one transaction on days before it ans on days after it ans add them up */
        /* the maximum of all of this will be our answer */
        
        int[] leftProfit = new int[prices.length]; // leftProfit[i] --> max profit on ith day staring from 0th day
        int[] rightProfit = new int[prices.length]; // rightProfit[i] --> max profit on ith day starting from last day
        
        int minPrice = prices[0]; //in going from Left to Right we need to buy then sell so we consider minPrice
        for(int i=1;i<prices.length;i++) {
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }
        
        int maxPrice = prices[prices.length - 1]; //in going from right to left i.e. against time we need to sell then buy so we need to consider maxPrice
        for(int i=prices.length - 2;i>=0;i--) {
            rightProfit[i] = Math.max(rightProfit[i+1], maxPrice - prices[i]);
            maxPrice = Math.max(prices[i], maxPrice);
        }
        
        //partitioning
        int ans = rightProfit[0];
        for(int i=1;i<prices.length;i++) {
            ans = Math.max(ans, leftProfit[i-1] + rightProfit[i]);
        }
        return ans;
    }
}
