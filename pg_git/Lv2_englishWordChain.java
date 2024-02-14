package pg_git;

import java.util.HashSet;
import java.util.Set;

class EnglishWordChain {
	public int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 }; // 초기값을 0,0으로 설정하여 탈락자가 없는 경우 그대로 return -> {번호, 차례}
		if (words[0].length() == 1) { // words의 0번째 문자열의 길이가 1인 경우 -> 인정되지 않으므로 1번을 배열에 저장
			answer[0] = 1;
			return answer;
		}

		Set<String> checkWord = new HashSet<>(); // words에 중복된 문자열을 걸러내기 위한 Set
		checkWord.add(words[0]); // words에 0번째 문자열을 Set에 저장

		for (int i = 1; i < words.length; i++) { // 0번째 문자열은 이미 Set에 저장 -> 1번째 문자열부터 검사 시작
			// 문자열의 길이가 1인 경우 || 이전 문자열의 끝 문자와 현재 문자열의 첫 문자가 다른 경우 || Set에 현재 문자열이 저장되었는 경우
			if (words[i].length() == 1 || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)
					|| !checkWord.add(words[i])) {  
				answer[0] = i % n + 1; // 사람 번호
				answer[1] = i / n + 1; // 차례 
				break;
			}
		}

		return answer;
	}
}

public class Lv2_englishWordChain {
	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };

		int[] ans = new EnglishWordChain().solution(n, words);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
