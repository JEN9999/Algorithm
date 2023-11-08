package Algorithm.Dynamic;
// 알고리즘 - 다이나믹 프로그래밍
// 큰문제를 부분문제로 나눈 후 답을 찾아가는 과정에서 계산된 결과를 기록하고 재활용
// 중간 계산 결과를 기록하기위한 메모리
// 한번 계산한 부분을 다시 계산하지 않음

public class Main {
    public static int fib(int n) {
        if( n <= 1){
            return n;
        }else{
            return fib(n - 1) + fib( n - 2);
        }
    }

    public static int fibDP(int n) {
        int[] dp = new int[ n < 2 ? 2 : n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[ i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int[] dp = new int[8];
    public static int fibDP2(int n) {
        if( n <= 2){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibDP2(n - 1) + fibDP2(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}
