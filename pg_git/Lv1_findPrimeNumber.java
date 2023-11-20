package pg_git;

class FindPrimeNumber {
	public int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			int cnt = 0;
			for (int j = 2; j <= (int)Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt++;
				}
				if (cnt > 0) {
					break;
				}
			}

			if (cnt == 0) {
				answer++;
			}
		}
		return answer;
	}
}

public class Lv1_findPrimeNumber {
	public static void main(String[] args) {
		int ans = new FindPrimeNumber().solution(10);
		System.out.println("---");
		System.out.println(ans);
	}
}
