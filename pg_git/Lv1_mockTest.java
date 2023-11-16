package pg_git;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MockTest {
	public int[] solution(int[] answers) {
		int[][] mathGiveUp = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		Map<Integer, Integer> correctAnswers = new HashMap<>();

		for (int i = 1; i <= 3; i++) {
			int[] m = mathGiveUp[i - 1];
			int leng = m.length - 1;
			int j = 0;
			int k = 0;
			while (true) {

				if (answers[k] == m[j]) {
					if (!correctAnswers.containsKey(i)) {
						correctAnswers.put(i, 0);
					}
					correctAnswers.put(i, correctAnswers.get(i) + 1);
				}

				if ((answers.length - 1) == k) {
					break;
				}

				if (j == leng) {
					j = 0;
				} else {
					j++;
				}

				k++;
			}
		}

		int maxCnt = 0;
		for (int key : correctAnswers.keySet()) {
			int value = correctAnswers.get(key);
			if (maxCnt < value) {
				maxCnt = value;
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int key : correctAnswers.keySet()) {
			int value = correctAnswers.get(key);
			if (maxCnt == value) {
				list.add(key);
			}
		}

		int[] answer = new int[list.size()];

		for (int l = 0; l < list.size(); l++) {
			answer[l] = list.get(l);
		}

		return answer;
	}
}

public class Lv1_mockTest {
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		int[] answer = new MockTest().solution(answers);

		for (int a : answer) {
			System.out.print(a + " ");
		}
	}
}
