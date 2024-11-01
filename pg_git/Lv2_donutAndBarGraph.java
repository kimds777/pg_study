package pg_git;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class DonutAndBarGraph { // 실패!! -> 다시 풀어보기
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int max_value = 0;
        for (int[] edge : edges) { // 가장 큰 수 찾기
            max_value = Math.max(max_value, Math.max(edge[0], edge[1]));
        }

        int[] outdegree = new int[max_value + 1]; // 배열에서 0번째 인덱스로 호출된 횟수
        int[] indegree = new int[max_value + 1]; // 배열에서 1번째 인덱스로 호출된 횟수

        for (int[] edge : edges) { // 호출된 횟수 카운트
            outdegree[edge[0]]++; // 0
            indegree[edge[1]]++; // 1
        }

        int peak = 0;
        for (int i = 1; i <= max_value; i++) {

            peak = (outdegree[peak] < outdegree[i]) ? i : peak;
            if (outdegree[i] == 0) {
                answer[2]++;
            } else if (outdegree[i] >= 2 && indegree[i] >= 2) {
                answer[3]++;
            }

        }


        answer[0] = peak;
        answer[1] = outdegree[peak] - answer[2] - answer[3];

        return answer;
    }
}

public class Lv2_donutAndBarGraph {
    public static void main(String[] args) {
//        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}}; // 2 1 1 0
//        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}; // 4 0 1 2
        int[][] edges = {{1, 12}, {8, 3}, {12, 7}, {7, 11}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}, {4, 11}, {4, 8}}; // 4 0 0 2
//        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}; // 4 0 0 2
        
        DonutAndBarGraph db = new DonutAndBarGraph();
        int[] answer = db.solution(edges);

        for (int a : answer) {
            System.out.print(a + " ");
        }

    }
}
