package pg_git;

class RepresentationOfNumbers {
	public int solution(int n) { // 숫자 n을 표현할 수 있는 방법을 구하는 메소드
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += j; // sum에 1~n까지 숫자를 더해 n을 표현할 수 있는지 확인한다.

				if (sum == n) { // sum이 n과 동일한 경우
					answer++; // n을 표현하는 방법 찾았으니 answer에 1을 더해준다.
					break; // 반복문을 빠져나간다.
				}

				if (sum > n) { // sum이 n보다 큰 경우
					break; // n보다 크니 조건에 맞지 않음 -> 반복문을 빠져나간다.
				}
			}
		}
		return answer;
	}
}

public class Lv2_representationOfNumbers {
	public static void main(String[] args) {
		int n = 15;

		int ans = new RepresentationOfNumbers().solution(n);
		System.out.println(ans);
	}
}
