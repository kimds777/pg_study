package pg_git;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_numberOfConsecutivePartialSequenceSums {
    public static int solution(int[] elements) {

        HashSet<Integer> sumNumber = new HashSet();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j <= elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += elements[k % elements.length];
                }
                sumNumber.add(sum);
            }
        }

        return sumNumber.size();
    }

    public static void main(String[] args) {
        int[] e = {7, 9, 1, 1, 4};
        System.out.println(solution(e));
    }
}
