class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = 0, max = 0;
        
        for(int i=1;i<prices.length;i++) {
            if(prices[i-1] <= prices[i]) {
                max = i;
            }else{
                maxProfit += prices[max] - prices[min] - fee;
                min = i;
                max = i;
            }
        }
        maxProfit += prices[max] - prices[min];
        return maxProfit;
    }
}
