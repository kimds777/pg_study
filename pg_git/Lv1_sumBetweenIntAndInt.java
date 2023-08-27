package pg_git;

public class Lv1_sumBetweenIntAndInt {
	public long solution(int a, int b) {
		long answer = 0;

		if (a > b) {
			for (int i = b; i <= a; i++) {
				answer += i;
			}
		} else if (b > a) {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		} else {
			answer = a;
		}

		return answer;
	}
	
// 삼항 연산자 for문 풀이!	
//	public long solution(int a, int b) {
//	      long answer = 0;
//	      for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++) 
//	          answer += i;
//
//	      return answer;
//	  }
}
