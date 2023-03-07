public class Counts_Vowels_Permutation_1220 {
    public int countVowelPermutationDP(int n) {
        int mod = 1000000007;
        long[][] dp = new long[n+1][5];

        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }

        int a = 0;
        int e = 1;
        int i = 2;
        int o = 3;
        int u = 4;

        for (int j = 2; j <= n; j++) {
            dp[j][a] = (dp[j-1][e] + dp[j-1][i] + dp[j-1][u]) % mod;
            dp[j][e] = (dp[j-1][a] + dp[j-1][i]) % mod;
            dp[j][i] = (dp[j-1][e] + dp[j-1][o]) % mod;
            dp[j][o] = dp[j-1][i];
            dp[j][u] = (dp[j-1][i] + dp[j-1][o]) % mod;
        }

        long count = 0;
        for (long num : dp[n]) {
            count += num;
            count %= mod;
        }
        return (int) count;
    }

    public int countVowelPermutationSpace(int n) {
        long mod = 1000000007;

        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        long newA, newE, newI, newO, newU;

        for (int j = 2; j <= n; j++) {
            newA = (e + i + u) % mod;
            newE = (a + i) % mod;
            newI = (e + o) % mod;
            newO = (i) % mod;
            newU = (o + i) % mod;
            a = newA;
            e = newE;
            i = newI;
            o = newO;
            u = newU;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
}

// 144
// -707914352
// 18208803
//
