package pg_git;

public class Lv1_divisorCountAndSum {
	public int solution(int left, int right) {
		int sum = 0;
		for (int i = left; i <= right; i++) {
			
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}		

			if (count % 2 == 0) {
				sum += i;
			} else {
				sum -= i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Lv1_divisorCountAndSum dca = new Lv1_divisorCountAndSum();
		dca.solution(13, 17);
	}
}
