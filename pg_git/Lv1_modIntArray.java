package pg_git;

import java.util.Arrays;

public class Lv1_modIntArray {
	public int[] solution(int[] arr, int divisor) {
		int cnt = 0;

		for (int a = 0; a < arr.length; a++) {
			if (arr[a] % divisor != 0) {
				arr[a] = 0;
				cnt++;
			}
		}
		

		if (cnt == arr.length) {
			int[] answer = { -1 };
			return answer;
		} else {
			int[] answer = new int[arr.length - cnt];
			int i = 0;
			for (int a : arr) {
				if (a != 0) {
					answer[i] = a;
					i++;
				}
			}			
			Arrays.sort(answer);
			return answer;
		}
	}
}
