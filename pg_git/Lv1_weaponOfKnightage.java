package pg_git;

class WeaponOfKnightage {
	public int solution(int number, int limit, int power) {
		int answer = 0;
		for (int i = 2; i <= number; i++) {
			int cnt = 1;
			int range = i / 2;
			for (int j = 1; j <= range; j++) {
				if (i % j == 0) {
					cnt++;
				}
			}

			if (cnt > limit) {
				answer += power;
			} else {
				answer += cnt;
			}
		}

		answer++;

		return answer;
	}
}

public class Lv1_weaponOfKnightage {
	public static void main(String[] args) {
		int number = 5, limit = 3, power = 2;

		int ans = new WeaponOfKnightage().solution(number, limit, power);
		System.out.println(ans);
	}
}
