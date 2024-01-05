package pg_git;

import java.util.HashMap;
import java.util.Map;

class ExaminePersonalityType {
	public String solution(String[] survey, int[] choices) {
		char[][] personalityType = { { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' } }; // 4개 지표 배열
		int[] score = { 0, 3, 2, 1, 0, 1, 2, 3 }; // 선택지별 점수 배열

		Map<Character, Integer> personalityTypeCheck = new HashMap<>();
		for (char[] keys : personalityType) {
			personalityTypeCheck.put(keys[0], 0);
			personalityTypeCheck.put(keys[1], 0);
		}

		for (int s = 0; s < survey.length; s++) {
			int c = choices[s];
			if (c < 4) { // 선택지별 점수가 3이하인 경우
				personalityTypeCheck.put(survey[s].charAt(0), // 문자열에 0번째 문자를
						personalityTypeCheck.get(survey[s].charAt(0)) + score[c]); // Map에서 0번째 문자로 값을 가져와 선택지별 점수를 더한다.
			}else { // 선택지별 점수가 4이상인 경우
				personalityTypeCheck.put(survey[s].charAt(1), // 문자열에 1번째 문자를 
						personalityTypeCheck.get(survey[s].charAt(1)) + score[c]); // Map에서 1번째 문자로 값을 가져와 선택지별 점수를 더한다.
			}

		}

		StringBuilder sb = new StringBuilder();
		for (char[] keys : personalityType) {
			int value1 = personalityTypeCheck.get(keys[0]);
			int value2 = personalityTypeCheck.get(keys[1]);

			if (value1 == value2 || value1 > value2) { // 성격유형 점수가 같거나 첫번째 유형의 점수가 더 놓은 경우
				sb.append(keys[0]);
			} else { // 두번째 유형 점수가 높은 경우
				sb.append(keys[1]);
			}
		}

		return sb.toString();
	}
}

public class Lv1_examinePersonalityType {
	public static void main(String[] args) {
		String[] survey = { "RT", "RT", "RT" };
		int[] choices = { 7, 5, 2 };

		String ans = new ExaminePersonalityType().solution(survey, choices);
		System.out.println(ans);
	}
}
