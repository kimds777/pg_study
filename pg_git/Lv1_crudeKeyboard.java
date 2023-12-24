package pg_git;

import java.util.HashMap;
import java.util.Map;

class CrudeKeyboard {
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		Map<Character, Integer> count = new HashMap<>();

		for (String k : keymap) { // keymap에서 동일한 문자의 최소 index 구하기
			for (int i = 0; i < k.length(); i++) { 
				char key = k.charAt(i);
				count.put(key, Math.min(i + 1, count.getOrDefault(key, Integer.MAX_VALUE))); // 동일한 문자가 있는경우 새로운 index와 기존 index를 비교
																							// 기존 index가 없고 처음 index값을 넣는 경우 Integer의 최대값과 비교
			}
		}

		for (int t = 0; t < targets.length; t++) {
			for (int j = 0; j < targets[t].length(); j++) {
				char key = targets[t].charAt(j); // targets의 문자열의 j번째 문자
				if (count.containsKey(key)) { // count에 key문자가 있는 경우
					answer[t] += count.get(key); // count에서 value을 가져와 answer에 더한다.
				} else { // count에 key문자가 없는 경우
					answer[t] = -1; // targets의 문자열의 answer값을 -1로 변경한뒤
					break; // 반복문을 빠져나간다.
				}
			}
		}

		return answer;
	}
}

public class Lv1_crudeKeyboard {
	public static void main(String[] args) {
		String[] keymap = { "AGZ", "BSSS" };
		String[] targets = { "ASA", "BGZ" };

		int[] ans = new CrudeKeyboard().solution(keymap, targets);
		for (int a : ans) {
			System.out.print(a + " ");

		}
	}
}
