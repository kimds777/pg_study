package pg_git;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_functionalDevelopment {
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> dateQue = new LinkedList();

        for (int i = 0; i < progresses.length; i++) {
            int date = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                date++;
            }

            dateQue.add(date);
        }

        Queue<Integer> answerQue = new LinkedList();

        int checkCnt = 1;
        while (!dateQue.isEmpty()) {
            int date = dateQue.poll();

            if (dateQue.isEmpty()) {
                answerQue.add(1);
                break;
            }

            for (int d : dateQue) {

                if (date >= d) {
                    checkCnt++;
                } else {
                    break;
                }

            }
            answerQue.add(checkCnt);

            while (checkCnt > 1) {
                dateQue.remove();
                checkCnt--;
            }

        }

        int[] answer = new int[answerQue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerQue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = solution(progresses, speeds);
        System.out.println("\nanswer =============");
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
