package pg_git;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class GymSuit { // 다시 작성해야함!
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		List<Integer> reserveCheck = Arrays.stream(reserve).boxed().collect(Collectors.toList());

		Arrays.sort(lost);
		Collections.sort(reserveCheck);

		for (int l : lost) {
			if (reserveCheck.contains(l)) { // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
				int index = reserveCheck.indexOf(l);
				reserveCheck.remove(index);
				answer++;
				continue;
			}
		}

		for (int l : lost) {
			System.out.println("===========" + l + "===========");
			System.out.println("reserveCheck: " + reserveCheck.toString());
			System.out.println("-----------------------");

			int front = l + 1;
			int back = l - 1;

			for (int r : reserveCheck) {
				if (front == r || back == r) { // 체육복을 도난 당한 학생의 앞/뒤번호 중 한명의 학생이라도 여벌 체육복을 가져온 경우
					System.out.println("r :" + r + ", front :" + front + ", back :" + back);
					int index = reserveCheck.indexOf(r);
					reserveCheck.remove(index);
					answer++;
					break;
				}
			}

			if (reserveCheck.size() == 0) {
				break;
			}
		}

		return answer;
	}
}

public class Lv1_gymSuit {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4, 5 };
		int[] reserve = { 1, 3, 5 };

		int ans = new GymSuit().solution(n, lost, reserve);
		System.out.println(ans);
	}
}
