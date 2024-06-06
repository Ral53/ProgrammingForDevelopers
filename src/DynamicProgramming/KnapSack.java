package DynamicProgramming;

public class KnapSack {
    int zeroOneKnapSack(int p[], int w[], int capacity) {
        // Create a 2D array to store the maximum value at each n items and capacity c
        int dp[][] = new int[p.length + 1][capacity + 1];

        // Iterate through each item
        for(int i = 1; i <= p.length; i++) {
            // Iterate through each capacity from 0 to given capacity
            for (int j = 0; j <= capacity; j++) {
                if (j >= w[i-1]) {
                    // Item can be included: max of excluding or including the item
                    dp[i][j] = Math.max(dp[i-1][j], p[i-1] + dp[i-1][j - w[i-1]]);
                } else {
                    // Item cannot be included, continue with previous item's max value
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // Return the maximum value that can be obtained with given items and capacity
        return dp[p.length][capacity];
    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = {2,3,1,4};
        int[] weights = {3,4,6,5};
        int capacity = 8;
        int maxProfit = ks.zeroOneKnapSack(profits, weights, capacity);
        System.out.println("Maximum profit: " + maxProfit); // Should output 220
    }
}
