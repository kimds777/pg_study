package pg_git;

public class Lv1_remainderOne {
	public static int Lv1_remainderOne(int n) {
		for (int i = 1; i < n; i++) {
			if (n % i == 1) {
				return i;
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		Lv1_remainderOne(10);
	}
}
