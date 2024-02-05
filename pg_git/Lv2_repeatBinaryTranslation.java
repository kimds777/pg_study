package pg_git;

class RepeatBinaryTranslation {

	public int[] solution(String s) {
		int[] answer = new int[2];
		while (!s.equals("1")) {
			int length = s.length(); // 0 제거 전 x의 길이

			s = s.replaceAll("0", ""); // x에서 모든 0 제거

			int removeZeroAfterLength = s.length(); // 모든 0을 제거한 x의 길이
			answer[1] += length - removeZeroAfterLength; // 제거된 0의 개수

			s = Integer.toBinaryString(removeZeroAfterLength); // 모든 0을 제거한 x의 길이를 이진 변환
			
			answer[0]++; // 이진 변환 횟수 1씩 증가
		}

		return answer;
	}

}

public class Lv2_repeatBinaryTranslation {
	public static void main(String[] args) {
		String s = "01110";

		int[] ans = new RepeatBinaryTranslation().solution(s);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
