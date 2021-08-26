/* LeetCode 121 - Best Time to Buy and Sell Stock */
class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0, sellDay = 0, profit = 0;
        
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[sellDay]) {
                sellDay = i;
            }else if(prices[i] < prices[buyDay]){
                buyDay = i;
                sellDay = i;
            }
            profit = Math.max(profit, prices[sellDay] - prices[buyDay]); 
        }
        
        return profit;
    }
}
