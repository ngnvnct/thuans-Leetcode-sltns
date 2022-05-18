public class find_n_integers_sum_zero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int unique = 1;
        if (n % 2 == 1) {
            res[0] = 0;
            for (int i = 1; i < n; i++) {
                if (i % 2 == 1) {
                    res[i] = unique;
                } else {
                    res[i] = -unique;
                    unique++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    res[i] = unique;
                } else {
                    res[i] = -unique;
                    unique++;
                }
            }
        }
        return res;
    }
}
