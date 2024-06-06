package DynamicProgramming;

public class Denomination {
    public int topDownCountCoins(int n, int[] coin, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) { // Check if dp[n] has already been calculated
            return dp[n]; // If yes, return the stored value
        }
        int minCoin = Integer.MAX_VALUE; // Initialize the minimum number of coins required to MAX_VALUE
        for (int i = 0; i < coin.length; i++) { // Iterate through each coin denomination
            if (n - coin[i] >= 0) { // Check if the current coin denomination can be used to make change for n
                int subAns = topDownCountCoins(n - coin[i], coin, dp); // Recursively calculate the minimum coins required for n - coin[i]
                if (subAns != Integer.MAX_VALUE && subAns + 1 < minCoin) { // Check if subAns is a valid solution and update minCoin accordingly
                    minCoin = subAns + 1; // Update minCoin with the minimum number of coins required
                }
            }
        }
        dp[n] = minCoin; // Store the calculated minimum number of coins for n in the dp array
        return dp[n]; // Return the minimum number of coins required for n
    }


    public int bottomUpCountCoins(int n, int[] coin, int[] dp) {
        dp[0] = 0; // Base case: 0 coins needed to make change for amount 0
        for (int i = 1; i <= n; i++) { // Iterate through each amount from 1 to n
            int minCoins = Integer.MAX_VALUE; // Initialize the minimum number of coins required to MAX_VALUE
            for (int j = 0; j < coin.length; j++) { // Iterate through each coin denomination
                if (i - coin[j] >= 0) { // Check if the current coin denomination can be used to make change for i
                    int coinsNeeded = dp[i - coin[j]] + 1; // Calculate the number of coins needed using the previously computed solutions
                    minCoins = Math.min(minCoins, coinsNeeded); // Update minCoins if a better solution is found
                }
            }
            dp[i] = minCoins; // Store the minimum number of coins required for amount i in the dp array
        }
        return dp[n]; // Return the minimum number of coins required for amount n
    }

    public static void main(String[] args) {
        Denomination denomination = new Denomination();
        int n = 20; // The target value to make change for
        int[] coin = {1, 5, 7}; // Available coin denominations
        int[] dp = new int[n + 1]; // Array to store computed results

        int result = denomination.topDownCountCoins(n, coin, dp);

        System.out.println("Minimum number of coins required: " + result);
    }

}

