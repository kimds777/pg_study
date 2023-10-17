package pg_git;

class Trio {
	public int solution(int[] number) {
		int answer = 0;
		int len = number.length;

		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					int temp = number[i] + number[j] + number[k];
					if (temp == 0) {
						answer++;
					}
				}
			}
		}

		return answer;
	}
}

public class Lv1_trio {
	public static void main(String[] args) {
		Trio t = new Trio();
		int[] number = {-1,1,-1,1};
		System.out.println(t.solution(number));
	}
}
