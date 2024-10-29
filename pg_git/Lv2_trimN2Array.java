package pg_git;

import java.util.Arrays;

public class Lv2_trimN2Array { // 런타임 에러 발생!!
    public static int[] solution(int n, long left, long right) {
        int[] array = new int[n * n];

        int cnt = 1;
        for (int i = 0; i < (n * n); i = i + n) {
            int repeat = cnt;
            for (int j = 0; j < n; j++) {

                if (repeat > 0) {
                    array[i + j] = cnt;
                    repeat--;
                } else {
                    array[i + j] = j + 1;
                }

                System.out.print(array[i + j] + " ");
            }
            cnt++;
        }

        int[] answer = Arrays.copyOfRange(array, (int) left, (int) right +1);
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        int[] ans = solution(n, left, right);
        System.out.println("------------------");
        for(int a : ans){
            System.out.print(a );
        }
    }
}
