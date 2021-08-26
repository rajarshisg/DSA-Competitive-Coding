class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        /*
           dp[i][0] --> max profit till ith day if i do not own stock on ith day
           dp[i][1] --> min profit till ith day if i own a stock on ith day
        */
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee; //We need to buy the stock to own it on first day
        
        for(int i=1;i<prices.length;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); //to not have stock on ith day either we already didn't have it or sold a stock
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee); //either we already owned the stock or bought one
        }
        
        return dp[prices.length - 1][0];
    }
}
