package pg_git;

import java.util.HashMap;
import java.util.Map;

public class Lv2_discountEvent {
    public static int solution(String[] want, int[] number, String[] discount) {
        int discountPeriod = 10; // 총 구매할 제품 갯수

        Map<String, Integer> wantMap = new HashMap(); // 제품별 int[] number index를 담을 map
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], i); // 제품별 int[] number index를 map에 넣기
        }

        int answer = 0;

        for (int i = 0; i <= discount.length - discountPeriod; i++) {
            int[] numberCopy = number.clone(); // 제품별 필요 갯수 저장
            
            for (int j = i; j < discountPeriod + i; j++) {
                int checkIndex = wantMap.getOrDefault(discount[j], -1); // want에 들어있는 제품이 아닌 경우 -1 출력
                if (checkIndex != -1) {
                    numberCopy[checkIndex] = numberCopy[checkIndex] > 0 ? numberCopy[checkIndex] - 1 : 0;
                }
            }

            int checkNum = 0;
            for (int num : numberCopy) {
                if (num != 0) { // 원하는 제품을 다 구매하지 못한 경우
                    checkNum++;
                    break;
                }
            }

            if (checkNum == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
}
