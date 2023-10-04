package pg_git;

class Solution {
	public long solution(int price, int money, int count) {
		long answer = 0;
		for (int i = 1; i <= count; i++) {
			answer += price * i;
		}

		if (answer <= money) {
			return 0;
		} else {
			answer -= money;
			return answer;
		}

	}
}

public class Lv1_shortAmount {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(3, 20, 4));
	}
}
