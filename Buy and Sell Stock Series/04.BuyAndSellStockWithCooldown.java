/* LeetCode 309 - Best Time to Buy and Sell Stock with Cooldown */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] noStock = new int[prices.length][2];
        int[] hasStock = new int[prices.length]; 
        
        /*
            noStock[i][0] --> max profit on ith day if we have no stock on ith day and we want there to be a cooldown
            noStock[i][1] --> max profit on ith day if we have stock on ith day and we want a cooldown
            hasStock[i][1] --> max profit on ith day if we have stock on ith day
        */
        
        noStock[0][0] = 0;
        noStock[0][1] = 0;
        hasStock[0] = -prices[0]; //to have a stock we need to buy it on first day
        
        for(int i=1;i<prices.length;i++) {
            noStock[i][1] = hasStock[i-1] + prices[i]; //to have cooldown we need to sell on that day
            noStock[i][0] = Math.max(noStock[i-1][0], noStock[i-1][1]); //we cannot sell as we want no cooldown
            hasStock[i] = Math.max(hasStock[i-1], noStock[i-1][0] - prices[i]); //we can buy only from if we have no cooldown on previous state
        }
        
        return Math.max(noStock[prices.length - 1][1], noStock[prices.length - 1][0]);
    }
}
