class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int max = prices[n-1];
        int maxProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, max - prices[i]);
            max = Math.max(prices[i], max);
        }
        return maxProfit;
    }
}