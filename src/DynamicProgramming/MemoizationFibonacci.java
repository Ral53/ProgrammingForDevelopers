package DynamicProgramming;

public class MemoizationFibonacci {

    public int fibo(int n, int dp[]) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != -1) {
            return dp[n];
        }
        dp[n] =  fibo(n - 1, dp) + fibo(n - 2, dp);
        return dp[n];
    }
     // REALLY INTERESTING

    public static void main(String[] args) {
        MemoizationFibonacci m = new MemoizationFibonacci();
        int n = 100;
        int[] dp = new int[n + 1]; // Memoization array
        for (int i = 0; i <= n; i++) {
            dp[i] = -1; // Initialize memoization array with -1
        }
        System.out.printf("Fibonacci of %d: %d\n", n, m.fibo(n, dp));
    }
}
