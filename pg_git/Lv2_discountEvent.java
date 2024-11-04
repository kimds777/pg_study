package pg_git;

import java.util.HashMap;
import java.util.Map;

public class Lv2_discountEvent {
    public static int solution(String[] want, int[] number, String[] discount) {
        int discountPeriod = 10; // �� ������ ��ǰ ����

        Map<String, Integer> wantMap = new HashMap(); // ��ǰ�� int[] number index�� ���� map
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], i); // ��ǰ�� int[] number index�� map�� �ֱ�
        }

        int answer = 0;

        for (int i = 0; i <= discount.length - discountPeriod; i++) {
            int[] numberCopy = number.clone(); // ��ǰ�� �ʿ� ���� ����
            
            for (int j = i; j < discountPeriod + i; j++) {
                int checkIndex = wantMap.getOrDefault(discount[j], -1); // want�� ����ִ� ��ǰ�� �ƴ� ��� -1 ���
                if (checkIndex != -1) {
                    numberCopy[checkIndex] = numberCopy[checkIndex] > 0 ? numberCopy[checkIndex] - 1 : 0;
                }
            }

            int checkNum = 0;
            for (int num : numberCopy) {
                if (num != 0) { // ���ϴ� ��ǰ�� �� �������� ���� ���
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
