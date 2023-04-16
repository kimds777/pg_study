package pg_git;

public class Lv1_divisorSum {
	public double Lv1_divisorSum(int n) {
		double answer = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				answer += n / i;
			}
		}
		return answer;
	}
}
