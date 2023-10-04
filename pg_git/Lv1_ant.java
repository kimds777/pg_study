package pg_git;

public class Lv1_ant {
	public int solution(int hp) {
		int count = 0;

		int a = 5;
		int b = 3;
		int c = 1;

		while (hp > 0) {
			if (hp - a >= 0) {
				hp -= a;
				count++;
			} else if (hp - b >= 0) {
				hp -= b;
				count++;
			} else {
				hp -= c;
				count++;
			}
		}

		return count;
	}
}
