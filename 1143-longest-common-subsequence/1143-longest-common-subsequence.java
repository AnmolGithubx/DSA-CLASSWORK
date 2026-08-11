class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int f(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + f(text1, text2, i + 1, j + 1, dp);

        return dp[i][j] = Math.max(
                f(text1, text2, i + 1, j, dp),
                f(text1, text2, i, j + 1, dp));
    }
}