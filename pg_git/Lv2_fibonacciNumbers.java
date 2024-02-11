package pg_git;

class FibonacciNumbers {
	public int solution(int n) {
		int[] N = new int[n + 1]; // 배열을 생성하여 계산된 값을 넣어 조회 속도 향상
		N[0] = 0; // F(0) = 0
		N[1] = 1; //F(1) = 1

		for (int i = 2; i <= n; i++) { // 2 ~ n번째 피보나치 수를 1234567로 나눈 나머지를 배열에 저장
			N[i] = (N[i - 1] + N[i - 2]) % 1234567;
		}
		
		return N[n]; // n번째 피보나치 수를 1234567로 나눈 나머지 출력
	}
}

public class Lv2_fibonacciNumbers {
	public static void main(String[] args) {
		int n = 5;

		int ans = new FibonacciNumbers().solution(n);
		System.out.println(ans);
	}
}
