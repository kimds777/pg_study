package pg_git;

class Cola {
	public int solution(int a, int b, int n) {
		int answer = 0;
		while (true) {
			int remainder = n % a;
			n = (n / a) * b;
			answer += n;
			if(n == 0) {
				break;
			}
			if (remainder != 0) {
				n += remainder;
			}
		}
		return answer;
	}
}

public class Lv1_cola {
	public static void main(String[] args) {
		int result = new Cola().solution(2, 1, 20);
		System.out.println(result);
	}
}
