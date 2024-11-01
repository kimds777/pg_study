package pg_git;

import java.util.Arrays;

public class Lv2_trimN2Array {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int cnt = 0;
        for (long i = left; i <= right; i++) {
            answer[cnt++] = (int) Math.max(i / n, i % n) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10000000;
        long left = 99999999999L;
        long right = 99999999999L;

        int[] ans = solution(n, left, right);
        for (long a : ans) {
            System.out.print(a);
        }
    }
}
