package easy;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    // Time complexity: O(N), Space complexity: O(1)
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (min > price)
                min = price;
            else if (price - min > ans)
                ans = price - min;
        }
        return ans;
    }
}
