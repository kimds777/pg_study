package pg_git;

import java.util.Arrays;

class GymSuit {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		Arrays.sort(lost); // 오름차순 정렬
		Arrays.sort(reserve); // 오름차순 정렬

		for (int l = 0; l < lost.length; l++) {
			for (int r = 0; r < reserve.length; r++) {
				if (lost[l] == reserve[r]) { // 체육복을 도난 당한 학생중 여벌 체육복을 가져온 경우
					answer++;
					reserve[r] = -1;
					lost[l] = -1;
					break;
				}
			}
		}

		for (int l : lost) {
			if (l == -1) {
				continue;
			}

			int frontNumber = l - 1; // 도난 당한 학생의 앞번호 
			int backNumber = l + 1; // 도난 당한 학생의 뒷번호

			for (int r = 0; r < reserve.length; r++) { 
				if (frontNumber == reserve[r] || backNumber == reserve[r]) { // 여벌 체육복을 가져온 학생의 번호가 도난 당한 학생의 앞번호 혹은 뒷번호인 경우 
					reserve[r] = -1;
					answer++;
					break;
				}
			}
		}

		return answer;
	}
}

public class Lv1_gymSuit {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 3 };

		int ans = new GymSuit().solution(n, lost, reserve);
		System.out.println(ans);
	}
}
