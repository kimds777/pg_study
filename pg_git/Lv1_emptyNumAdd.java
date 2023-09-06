package pg_git;

public class Lv1_emptyNumAdd {
	public int solution(int[] numbers) {
		int answer = 0;
		
		for (int a = 1; a <= 9; a++) {
			answer += a;
		}

		for (int n = 0; n < numbers.length; n++) {
			answer -= numbers[n];
		}
		return answer;
	}
	
//	for 확장문 및 answer 총합 버전
//	public int solution(int[] numbers) {
//		int answer = 45;
//
//		for (int n : numbers) {
//			answer -= n;
//		}
//		return answer;
//	}
}
