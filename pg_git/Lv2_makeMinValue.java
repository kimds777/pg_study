package pg_git;

import java.util.Arrays;

class MakeMinValue {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A); // 배열A 오름차순 정렬
		Arrays.sort(B); // 배열B 오름차순 정렬
		
		int answer = 0;
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[B.length - i - 1]; // A배열의 가장 작은 수 * B배열의 가장 큰 수를 answer에 더해준다.
		}

		return answer;
	}
}

public class Lv2_makeMinValue {
	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { 3, 4 };

		int ans = new MakeMinValue().solution(A, B);
		System.out.println(ans);
	}
}
