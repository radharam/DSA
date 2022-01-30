package src.main.java.interviewbit.contest.fellowclassmate;

public class MakeThemEqual {

    public int solve(int[] A) {
        if (A.length == 1) return 0;
        int bitsInSmall = countOfBits(smallest(A));
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            while (countOfBits(A[i]) > bitsInSmall) {
                A[i] /= 2;
                ans++;
            }
        }
        while (!allSame(A)) {
            ans += A.length;
            for (int i = 0; i < A.length; i++) A[i] /= 2;
        }
        return ans;
    }

    private int countOfBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 2;
        }
        return cnt;
    }

    private boolean allSame(int[] A) {
        for (int j : A) if (j != A[0]) return false;
        return true;
    }

    private int smallest(int[] A) {
        int res = A[0];
        for (int i : A) res = Math.min(res, i);
        return res;
    }
}