package pg_git;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_process {
    public static int solution(int[] priorities, int location) {
        int[] arr = priorities.clone();
        Arrays.sort(arr);

        Queue<Integer> que = new LinkedList();
        for (int p : priorities) {
            que.add(p);
        }

        int leng = arr.length - 1;
        int answer = 0;

        while (true) {

            if (que.peek() == arr[leng]) {
                que.poll();
                leng--;
                answer++;

                if (location == 0) {
                    return answer;
                }

            } else {
                que.offer(que.poll());
            }

            location = location > 0 ? location - 1 : que.size() - 1;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }
}
