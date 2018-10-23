package G;

public class MaxVacationDays {
    public static void main(String[] args) {
        int[][] flights ={{0,1,1},{1,0,1},{1,1,0}};
        int[][] days ={{1,3,1},{6,0,3},{3,3,3}};
        System.out.println(new MaxVacationDays().maxVacationDays(flights,days));
    }
    public int maxVacationDays(int[][] flights, int[][] days) {
        int K = days[0].length;
        int N = flights.length;
        int[][] dp = new int[K][N];

        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < N; ++j) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = days[0][0];
        for (int i = 0; i < N; ++i) {
            if (flights[0][i] == 1) {
                dp[0][i] = days[i][0];
            }
        }

        for (int k = 0; k < K - 1; ++k) {
            for (int i = 0; i < N; ++i) {
                if (dp[k][i] >= 0) {
                    dp[k + 1][i] = Math.max(dp[k + 1][i], dp[k][i] + days[i][k + 1]);
                    for (int j = 0; j < N; ++j) {
                        if (flights[i][j] == 1) {
                            dp[k + 1][j] = Math.max(dp[k + 1][j], dp[k][i] + days[j][k + 1]);
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; ++i) {
            res = Math.max(res, dp[K - 1][i]);
        }
        return res;
    }
}
