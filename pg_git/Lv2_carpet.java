package pg_git;

class Carpet {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int w = 2; // 카펫 가로길이 초기값
		int total = brown + yellow; // 갈색과 노란색 격자 총합
		while (true) {
			if (total % w == 0) { // 총합 % 가로 길이 = 0 인 경우
				int h = total / w; // 세로 길이
				if (w >= h && (w + h - 2) * 2 == brown) { // 가로길이 >= 세로길이 이고 (가로+세로-겹치는 칸)*2 == 갈색 칸인 경우
					answer[0] = w; 
					answer[1] = h;
					break;
				}
			}

			w++;

		}

		return answer;
	}
}

public class Lv2_carpet {
	public static void main(String[] args) {
		int brown = 3004;
		int yellow = 2996;

		int[] ans = new Carpet().solution(brown, yellow);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
