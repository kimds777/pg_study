package pg_git;

public class Lv1_cipherSum {
	public int Lv1_cipherSum(int n) {
		int sum = 0;
		do {
			sum += n % 10;
			n = n / 10;
		} while (n > 0);
		return sum;

	}
}
