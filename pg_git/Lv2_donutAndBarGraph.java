package pg_git;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class DonutAndBarGraph { // 실패!! -> 다시 풀어보기
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, HashSet<Integer>> checkInNumber = new HashMap<>();


        for (int[] edge : edges) { // 새로 생성된 정점 찾기
            int inNumber = edge[0];

            if (!checkInNumber.containsKey(inNumber)) { // checkInNumber에 inNumber가 key값으로 등록되지 않은 경우
                HashSet<Integer> saveNumber = new HashSet<>();

                for (int[] e : edges) {

                    if (e[1] == inNumber) {
                        break;
                    }

                    if (e[0] == inNumber) {
                        saveNumber.add(e[1]);
                    }

                }

                checkInNumber.put(inNumber, saveNumber);
            }
        }

        int maxKey = 0;
        for (int key : checkInNumber.keySet()) {
            if (maxKey == 0) {
                maxKey = key;
            }

            if (checkInNumber.get(maxKey).size() < checkInNumber.get(key).size()) {
                maxKey = key;
            }
        }

        answer[0] = maxKey; // 정점 저장
        answer[1] = checkInNumber.get(maxKey).size(); // 도넛 그래프 개수에 모든 그래프 개수 저장
//        System.out.println("이게 생성한 정점 : " + answer[0] + ", 그래프 개수 : " + answer[1]);


//        HashSet<Integer> saveOutNumber = checkInNumber.get(maxKey); // 정점과 연결된 그래프 정점들
//        for (int outNumber : saveOutNumber) {
//            int cntNumber = 0;
//            for (int[] edge : edges) {
//                if(edge[0] != maxKey){
//                    if(edge[1] == outNumber){
//                        cntNumber++;
//                    }
//                }
//            }
//
//            if(cntNumber == 2){
//
//            }
//        }

        for (int[] edge : edges) {

            if (edge[0] != maxKey) {

                int outNumber = edge[1];
                int cntNumber = 0;
                for (int[] e : edges) {
                    if (e[0] != maxKey && edge[0] != e[0]) {
                        if (outNumber == e[1]) {
                            cntNumber++;
                        }

                    }

                    if (outNumber == e[0]) {
                        cntNumber++;
                    }
                }
                System.out.println(edge[0]+","+edge[1]+" -> cntNumber : "+cntNumber);
                if (cntNumber == 0) {
                    answer[1]--;
                    answer[2]++;
                }

                if (cntNumber == 2) {
                    answer[1]--;
                    answer[3]++;
                }
            }
        }

        return answer;
    }
}

public class Lv2_donutAndBarGraph {
    public static void main(String[] args) {
//        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        DonutAndBarGraph db = new DonutAndBarGraph();
        int[] answer = db.solution(edges);

        for (int a : answer) {
            System.out.print(a + " ");
        }

    }
}
